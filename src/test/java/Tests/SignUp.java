package Tests;

import Model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

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
