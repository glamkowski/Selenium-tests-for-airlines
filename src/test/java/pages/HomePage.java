package pages;

import tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.SeleniumHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class HomePage extends TestBase {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='select2-chosen' and text()='Search by Hotel or City Name']")
    private WebElement searchArea;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchInput;

    @FindBy(name = "checkin")
    public WebElement startDateButton;

//    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
//    public WebElement contextCityName;

    @FindBy(xpath = "//td[@class='day ']")
    List<WebElement> datesFromList;

    @FindBy(css = "input[name='travellers']")
    WebElement travellers;

    @FindBy(id = "adultInput")
    WebElement adultInput;

    @FindBy(id = "childInput")
    WebElement childInput;

    @FindBy(xpath = "//button[text()=' Search']")
    WebElement searchButton;

    @FindBy(xpath = "//h2[@class='text-center']")
    public WebElement noResultsFoundText;

    @FindBy(xpath = "//li[@id='li_myaccount']")
    List<WebElement> myAccountLink;

    @FindBy(xpath = "//a[text()='  Sign Up']")
    List<WebElement> signupLink;

    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
    public WebElement contextCityName;

    public void setCity(String value) {
        logger.info("Setting city " + value);
        searchArea.click();
        searchInput.clear();
        searchInput.sendKeys(value);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", value);
        SeleniumHelper.waitForElementExist(driver, By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Setting city " + value + " done");
    }

    public void setStartDate(String value) {
        logger.info("Setting start date");
        startDateButton.click();
        datesFromList.stream().filter(e -> e.isDisplayed() && e.getText().equals(value)).findFirst().ifPresent(e -> e.click());
        logger.info("Setting start date done");
    }

    public void setTravellers(String adults, String kids) {
        logger.info("Setting travels as " + adults + " adults and" + kids + " kids");
        travellers.click();

        try { Thread.sleep(3000); }
        catch (Exception e) {

        }

        adultInput.click();
        adultInput.clear();
        adultInput.sendKeys(adults);

        childInput.click();
        childInput.clear();
        childInput.sendKeys(kids);
        logger.info("Setting travels done");

    }

    public void clickSearchButton() {
        logger.info("Clicking on the search button");
        searchButton.click();
        logger.info("Clicking on the search button done");
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public SignupPage goToSignupForm() {
        myAccountLink
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());
        signupLink
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());

        return new SignupPage(driver);
    }

    public String getDateInNthDays (Integer days) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("DD");
        Integer startDate = Integer.parseInt(dateTimeFormatter.format(LocalDateTime.now()));
        startDate += days;
        return  startDate.toString();
    }

}
