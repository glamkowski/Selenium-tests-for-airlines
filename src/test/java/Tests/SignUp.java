package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.SignupPage;
import Tests.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SignUp extends TestBase {

    @Test
    public void shouldSignup() {

        homePage.goToSignupForm();
        signupPage.setRandomFirstname();
        signupPage.setRandomLastname();
        signupPage.setRandomEmail();
        signupPage.setRandomPhone();
        signupPage.setRandomPassword();
        signupPage.clickSignupButton();

        Assert.assertTrue(accountPage.getHiHeader().contains("Hi"));

    }

    @Test
    public void shouldNotSignup() {

        homePage.goToSignupForm();
        signupPage.clickSignupButton();

        String[] alerts = new String[]{
                "The Email field is required.",
                "The Password field is required.",
                "The Password field is required.",
                "The First name field is required.",
                "The Last Name field is required."
        };

        if (alerts.length == signupPage.getAlertsList().size()) {
            for (int i = 0; i < signupPage.getAlertsList().size(); i++) {
                Assert.assertEquals(alerts[i], signupPage.getAlertsList().get(i).getText());
                System.out.println(alerts[i] + " ---- " + signupPage.getAlertsList().get(i).getText());
            }
        } else {
            Assert.assertEquals(alerts.length, signupPage.getAlertsList().size());
            System.out.println("The form has too many alerts");
        }

    }
}
