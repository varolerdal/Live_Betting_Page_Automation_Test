package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Ensures the timeout value is received from ConfigReader
    public BasePage(WebDriver driver) {
        this.driver = driver;
        String timeoutValue = ConfigReader.getProperty("timeout");
        if (timeoutValue == null || timeoutValue.isEmpty()) {
            throw new RuntimeException("Timeout value is not set or invalid in config.properties!");
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(timeoutValue)));
    }

    // Creates method to wait until element becomes clickable
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Creates a method to wait until element is displayed
    public void waitAndVerify(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(element.isDisplayed());
    }

    // Creates a method to wait until all elements are displayed
    public void waitAndVerifyAll(WebElement... elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}