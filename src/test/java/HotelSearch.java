import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HotelSearch {

    public WebDriver driver;

    @BeforeTest
    public void setup () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (System.getProperty("os.name").contains("Mac")) {
            chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @Test
    public void HotelSearch () throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://kurs-selenium.pl");

        driver.findElement(By.xpath("//span[@class='select2-chosen' and text()='Search by Hotel or City Name']")).click();

        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-match' and text()='Dubai']")));
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();

        driver.findElement(By.name("checkin")).click();

        //td[@class='day ' and text()='12']

    }

    @AfterTest
    public void cleanUp () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
