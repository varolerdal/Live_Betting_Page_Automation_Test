package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LiveBettingPage;

import java.time.Duration;

public class SportSortingSteps {

    WebDriver driver = stepdefinitions.Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    LiveBettingPage liveBettingPage = new LiveBettingPage(driver);

    @When("I open the A-Z Sports list")
    public void i_open_the_a_z_sports_list() {

        // Waits until A-Z Sports tab becomes clickable then clicks
        liveBettingPage.waitAndClick(liveBettingPage.azSports);
    }

    @Then("I select the sport Formula 1")
    public void i_select_the_sport_formula_1() {

        // Waits until Formula 1 becomes clickable then clicks
        liveBettingPage.waitAndClick(liveBettingPage.formula1TitleButton);
    }

    @And("Formula 1 tab should be highlighted")
    public void formula_1_tab_should_be_highlighted() {

        // Waits until Formula 1 tab becomes highlighted then verifies
        liveBettingPage.waitAndVerify(liveBettingPage.formula1TabHighlighted);
    }

    @And("The URL should indicate Formula 1")
    public void the_url_should_indicate_formula_1() {

        // Stores Formula 1 as text
        String formula1text = liveBettingPage.formula1TabHighlighted.getText();

        // Turns Formula 1 to lower case, replaces " " with "-" and stores it as text
        String formula1UrlText = formula1text.toLowerCase().replace(" ", "-");

        // Stores the URL of the current page
        String currentUrl = driver.getCurrentUrl();

        // Verifies that the URL contains "formula-1"
        Assert.assertTrue(currentUrl.contains(formula1UrlText));
    }
}