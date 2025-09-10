package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveBettingPage extends pages.BasePage {

    public LiveBettingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
}

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesAllowAllButton;

    @FindBy(id = "ds-tab-id-1-2")
    public WebElement eventViewButton;

    @FindBy(xpath = "(//*[@class='result-odds'])[1]")
    public WebElement firstBetOddValue;

    @FindBy(xpath = "(//*[@class='result-odds'])[2]")
    public WebElement secondBetOddValue;

    @FindBy(xpath ="(//*[contains(@class, 'betslip-pick-odds__value')])[1]")
    public WebElement betSlipOddValue;

    @FindBy(xpath ="(//*[@class='option-indicator selected'])[1]")
    public WebElement pickHighlighted;

    @FindBy(xpath ="//*[text()=' Table Tennis ']")
    public WebElement tableTennisbutton;

    @FindBy(xpath ="(//*[@class='option option-value ng-star-inserted'])[1]")
    public WebElement oddValue;

    @FindBy(xpath ="//*[@class='option-indicator increased']")
    public WebElement oddIncreased;

    @FindBy(xpath ="//*[@class='option-indicator decreased']")
    public WebElement oddDecreased;

    @FindBy(xpath ="//*[@data-testid=\"all\"]")
    public WebElement azSports;

    @FindBy(xpath ="//*[text()='Formula 1']")
    public WebElement formula1TitleButton;

    @FindBy(xpath ="//*[text()='Formula 1']")
    public WebElement formula1TabHighlighted;

    @FindBy(id = "bwin-logo")
    public WebElement bwinLogo;

    @FindBy(xpath ="//span[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath ="//span[text()='Log in']")
    public WebElement logInButton;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/sports']")
    public WebElement sportsBettingPageButtonOnDesktop;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/games']")
    public WebElement casinoPageButton;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/sports/live/betting']")
    public WebElement liveBettingPageButton;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/games/livecasino']")
    public WebElement liveCasinoPageButton;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/poker']")
    public WebElement pokerPageButtonOnDesktop;

    @FindBy(xpath ="//a[@href='https://www.bwin.com/en/promo/offers']")
    public WebElement offersPageButtonOnDesktop;

    @FindBy(xpath ="//*[@textclass='text-truncate d-block'][5]")
    public WebElement myBetsButtonOnMobile;

}
