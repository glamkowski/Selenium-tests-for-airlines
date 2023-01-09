package Tests;

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

        driver.findElement(By.xpath("")).click();

    }

    @Test
    public void shouldNotSignup() {
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());

        driver.findElements(By.xpath("//a[@class='go-text-right' and text()='  Sign Up']"))
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());

        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        String[] alerts = new String[]{
                "The Email field is required.",
                "The Password field is required.",
                "The Password field is required.",
                "The First name field is required.",
                "The Last Name field is required."
        };

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='resultsignup']//p")));
        List<WebElement> alertsFromPage = driver.findElements(By.xpath("//div[@class='resultsignup']//p"));

        if (alerts.length == alertsFromPage.size()) {
            for (int i = 0; i < alertsFromPage.size(); i++) {
                Assert.assertEquals(alerts[i], alertsFromPage.get(i).getText());
                System.out.println(alerts[i] + " ---- " + alertsFromPage.get(i).getText());
            }
        } else {
            Assert.assertEquals(alerts.length, alertsFromPage.size());
            System.out.println("The form has too many alerts");
        }

    }


}
