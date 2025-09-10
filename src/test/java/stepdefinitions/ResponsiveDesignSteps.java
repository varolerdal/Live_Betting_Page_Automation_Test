package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LiveBettingPage;
import utils.ReusableMethods;

import java.time.Duration;

public class ResponsiveDesignSteps {

    WebDriver driver = stepdefinitions.Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    LiveBettingPage liveBettingPage = new LiveBettingPage(driver);

    @When("I set the browser viewport to {string}")
    public void i_set_the_browser_viewport_to(String device) {

        // Calls the method created in ReusableMethods class to set viewport size based on whether for desktop or mobile
        ReusableMethods.setDimension(device);
    }

    @And("bwin logo, Register button and Log In button should be visible for {string}")
    public void bwin_logo_register_button_and_log_in_button_should_be_visible_for(String device) {

        // Waits until bwin logo, Register button and Log In buttons are displayed then verifies
        liveBettingPage.waitAndVerifyAll(
                liveBettingPage.bwinLogo,
                liveBettingPage.registerButton,
                liveBettingPage.logInButton);
    }

    @And("The navigation menu buttons should be visible for {string}")
    public void the_navigation_menu_buttons_should_be_correct_for(String device) {

        // Waits until Casino, Live Betting and Live Casino buttons are displayed then verifies
        liveBettingPage.waitAndVerifyAll(
                liveBettingPage.casinoPageButton,
                liveBettingPage.liveBettingPageButton,
                liveBettingPage.liveCasinoPageButton);

        if (device.equalsIgnoreCase("desktop"))  {

            // If the test is done for desktop viewport size, waits until Sport Betting, Poker, Offers buttons are displayed then verifies
            liveBettingPage.waitAndVerifyAll(
                    liveBettingPage.sportsBettingPageButtonOnDesktop,
                    liveBettingPage.pokerPageButtonOnDesktop,
                    liveBettingPage.offersPageButtonOnDesktop);
        }

        else {

            // If the test is done for mobile viewport size, waits until My Bets button is displayed then verifies
            liveBettingPage.waitAndVerify(liveBettingPage.myBetsButtonOnMobile);
        }
    }
}

