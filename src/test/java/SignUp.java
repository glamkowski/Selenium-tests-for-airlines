import com.github.javafaker.Faker;
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

        driver.findElement(By.name("firstname")).sendKeys(new Faker().name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(new Faker().name().lastName());
        driver.findElement(By.name("phone")).sendKeys(new Faker().phoneNumber().cellPhone());
        driver.findElement(By.name("email")).sendKeys(new Faker().internet().emailAddress());
        String password = new Faker().internet().password();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();



    }



}
