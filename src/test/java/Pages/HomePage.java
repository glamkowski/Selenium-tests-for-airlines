package Pages;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.Format;
import java.util.Formatter;
import java.util.List;


public class HomePage extends TestBase {

    public WebDriver driver;

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

    public void setCity(String value) {
        searchArea.click();
        searchInput.clear();
        searchInput.sendKeys(value);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", value);
        driver.findElement(By.xpath(xpath)).click();
    }

    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
    public WebElement contextCityName;

    public void setStartDate(String value) {
        startDateButton.click();
        datesFromList.stream().filter(e -> e.isDisplayed() && e.getText().equals(value)).findFirst().ifPresent(e -> e.click());
    }

    public void setTravellers(String adults, String kids) {
        travellers.click();

        adultInput.click();
        adultInput.clear();
        adultInput.sendKeys(adults);

        childInput.click();
        childInput.clear();
        childInput.sendKeys(kids);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public void goToSignupForm() {
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
    }

}
