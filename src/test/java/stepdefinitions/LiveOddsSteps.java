package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LiveBettingPage;

import java.time.Duration;

public class LiveOddsSteps {

    WebDriver driver = stepdefinitions.Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
    LiveBettingPage liveBettingPage = new LiveBettingPage(driver);

    @When("I select Table Tennis live events")
    public void i_select_table_tennis_live_events() {

        // Waits until the Table Tennis button is clickable then clicks
        liveBettingPage.waitAndClick(liveBettingPage.tableTennisbutton);
    }

    @Then("I view the first live event, wait until the odds update and verify it")
    public void i_view_the_first_live_event_and_wait_until_the_odds_update() {

        // Waits until the top game, first odd value becomes visible
        wait.until(ExpectedConditions.visibilityOf(liveBettingPage.oddValue));

        // Stores the starting odd value of the top-first game
        String baseOdd = liveBettingPage.oddValue.getText();

        // Waits until starting odd value of the respective odd updates
        try {
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.textToBePresentInElement(liveBettingPage.oddValue, baseOdd)));
        }

        // Test fails in case the respective odd is not updated
        catch (TimeoutException e) {
            Assert.fail();
        }

        // Stores the updated odd value
        String updatedOdd = liveBettingPage.oddValue.getText();

        // Verifies that the starting odd value does not match with the updated odd value
        Assertions.assertNotEquals(baseOdd, updatedOdd);
    }

    @And("the odds update indicators should be visible")
    public void the_new_odds_should_be_displayed_without_refreshing_the_page() {

        // Waits until the updated odd value is either increased or decreased then verifies
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(liveBettingPage.oddIncreased),
                    ExpectedConditions.visibilityOf(liveBettingPage.oddDecreased)));
            Assert.assertTrue(true);
        }

        // Test fails if the above condition is not met
        catch (Exception e) {
            Assert.fail();
        }
    }
}