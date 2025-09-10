package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LiveBettingPage;
import utils.ConfigReader;

import java.time.Duration;

public class BetslipSteps {

    WebDriver driver = stepdefinitions.Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    LiveBettingPage liveBettingPage = new LiveBettingPage(driver);

    @Given("I am on the Live Betting page")
    public void i_am_on_the_live_betting_page() {

        // Navigates to Live Betting page
        driver.get(ConfigReader.getProperty("url"));

        // Waits until the Allow All button is clickable then clicks
        liveBettingPage.waitAndClick(liveBettingPage.cookiesAllowAllButton);
    }

    @When("I navigate to the Event View page")
    public void i_navigate_to_the_event_view_page() {

        // Waits until the Event View button is clickable then clicks
        liveBettingPage.waitAndClick(liveBettingPage.eventViewButton);
    }

    // Creates a variable for the selected bet odd value
    String selectedBetOddValue;

    @When("I add a pick to the Betslip")
    public void i_add_a_pick_to_the_betslip() {

        // Tries to wait until the first odd value is visible, stores its value then clicks
        try {
            wait.until(ExpectedConditions.visibilityOf(liveBettingPage.firstBetOddValue));
            selectedBetOddValue = liveBettingPage.firstBetOddValue.getText();
            liveBettingPage.firstBetOddValue.click();
        }
        // If the first odd value does not appear, waits for the second odd value, stores it then clicks
        catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(liveBettingPage.secondBetOddValue));
            selectedBetOddValue = liveBettingPage.secondBetOddValue.getText();
            liveBettingPage.secondBetOddValue.click();
        }
    }

    @Then("The pick should be visible in the Betslip")
    public void the_pick_should_be_visible_in_the_betslip() {

        // Waits until the selected odd value appears in Betslip
        wait.until(ExpectedConditions.visibilityOf(liveBettingPage.betSlipOddValue));

        // Stores the selected bet value appearing in Betslip
        String betSlipOddValue = liveBettingPage.betSlipOddValue.getText();

        // Verifies that the first odd value matches with the bet value in Betslip
        Assert.assertEquals(selectedBetOddValue, betSlipOddValue);
    }
    @Then("The pick should be highlighted")
    public void the_pick_should_be_highlighted() {

        // Waits until the selected odd value is highlighted then verifies
        liveBettingPage.waitAndVerify(liveBettingPage.pickHighlighted);
    }
}
