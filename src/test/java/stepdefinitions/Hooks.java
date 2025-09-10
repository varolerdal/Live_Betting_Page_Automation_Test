package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import drivers.DriverManager;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportManager;

import java.time.Duration;
import java.util.Base64;

public class Hooks {

    private static WebDriver driver;
    private static ExtentReports extent = ExtentReportManager.getReporter();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @AfterStep
    public void logStepResult(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().log(Status.FAIL, "Step failed in scenario: " + scenario.getName());

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String base64Screenshot = Base64.getEncoder().encodeToString(screenshot);
            test.get().addScreenCaptureFromBase64String(base64Screenshot);
        } else {
            test.get().log(Status.PASS, "Step passed");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (!scenario.isFailed()) {
            test.get().log(Status.PASS, "Scenario passed: " + scenario.getName());
        }
        DriverManager.quitDriver();
        extent.flush();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}