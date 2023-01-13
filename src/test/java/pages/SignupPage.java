package pages;

import tests.TestBase;
import com.github.javafaker.Faker;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignupPage extends TestBase {

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "firstname")
    WebElement fnameInput;

    @FindBy(name = "lastname")
    WebElement lnameInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "confirmpassword")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()=' Sign Up']")
    WebElement signupButton;

    @FindBy(xpath = "//div[@class='resultsignup']//p")
    List<WebElement> alerts;

    private void sendKeys(String value, WebElement element) {
        element.sendKeys(value);
        System.out.println(element.getTagName() + " set to " + value);
    }

    public SignupPage setRandomFirstname() {
        sendKeys(new Faker().name().firstName(), fnameInput);
        return this;
    }

    public SignupPage setRandomLastname() {
        sendKeys(new Faker().name().lastName(), lnameInput);
        return this;
    }

    public SignupPage setRandomPhone() {
        sendKeys(new Faker().numerify("#########"), phoneInput);
        return this;
    }

    public SignupPage setRandomEmail() {
        sendKeys(new Faker().internet().emailAddress(), emailInput);
        return this;
    }

    public SignupPage setRandomPassword() {
        logger.info("Setting random password");
        String password = new Faker().internet().password();
        sendKeys(password, passwordInput);
        sendKeys(password, confirmPasswordInput);
        logger.info("Setting random password done");
        return this;
    }

    public SignupPage fillUpSignupForm (User user) {
        logger.info("Filling up signup form");
        sendKeys(user.getFirstName(), fnameInput);
        sendKeys(user.getLastName(), lnameInput);
        sendKeys(user.getPhone(), phoneInput);
        sendKeys(user.getPassword(), passwordInput);
        sendKeys(user.getPassword(), confirmPasswordInput);
        logger.info("Filling signup form done");
        return this;
    }

    public AccountPage clickSignupButton () {
        signupButton.click();
        return new AccountPage(driver);
    }

    public List<WebElement> getAlertsList() {
        return alerts;
    }
}