package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import tools.ExcelReader;

import javax.swing.*;
import java.io.IOException;

public class SignUp extends TestBase {

    @Test
    public void shouldSignup() {

        String welcomeHead = homePage.goToSignupForm()
                .setRandomFirstname()
                .setRandomLastname()
                .setRandomEmail()
                .setRandomPhone()
                .setRandomPassword()
                .clickSignupButton()
                .getHiHeader();

        Assert.assertTrue(welcomeHead.contains("Hi"));

    }

    @Test
    public void shouldSignupManual() {

        User user = new User("Oskar", "Testowy", "837627111", "oskar@oskar.os", "334422@A");
        homePage.goToSignupForm();
        signupPage.fillUpSignupForm(user);
        signupPage.clickSignupButton();

        Assert.assertEquals(signupPage.getAlertsList().get(0).getText(), "The Email field is required.");
    }

    @DataProvider(name = "dataFromExcel")
    public String[][] dataProviderForSignup () throws IOException {
        return ExcelReader.getDataFromExcel();
    }

    @Test(dataProvider = "dataFromExcel")
    public void shouldNotSignupUsingDataFromExcel (String fristname, String lastname, String phone, String password) {
        homePage.goToSignupForm();
        signupPage.signupUsingFromExcelData(fristname, lastname, phone, password);
        signupPage.clickSignupButton();
        Assert.assertEquals(signupPage.getAlertsList().get(0).getText(), "The Email field is required.");
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
