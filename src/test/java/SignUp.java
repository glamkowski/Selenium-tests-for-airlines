import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends TestBase {


    @Test
    public void signUp () {

        driver.get("http://www.kurs-selenium.pl");

        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());

        driver.findElements(By.xpath("//a[text()='  Sign Up']"))
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst()
                .ifPresent(e -> e.click());




    }



}
