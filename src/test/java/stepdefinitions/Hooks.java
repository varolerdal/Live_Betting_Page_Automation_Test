package stepdefinitions;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
