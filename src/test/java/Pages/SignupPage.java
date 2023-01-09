package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    private void sendKeys(String value, WebElement element) {
        element.sendKeys(value);
        System.out.println(element.getTagName() + " set to " + value);
    }

    public void setRandomFirstname() {
        sendKeys(new Faker().name().firstName(), fnameInput);
    }

    public void setRandomLastname() {
        sendKeys(new Faker().name().lastName(), lnameInput);
    }

    public void setRandomPhone() {
        sendKeys(new Faker().phoneNumber().cellPhone(), phoneInput);
    }

    public void setRandomEmail() {
        sendKeys(new Faker().phoneNumber().cellPhone(), emailInput);
    }

    public void setRandomPassword() {
        String password = new Faker().internet().password();
        sendKeys(password, passwordInput);
        sendKeys(password, confirmPasswordInput);
    }

    public void clickSignupButton () {
        signupButton.click();
    }
}