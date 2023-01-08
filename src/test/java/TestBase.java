import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (System.getProperty("os.name").contains("Mac")) {
            chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
        }
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
        this.driver.get("http://www.kurs-selenium.pl");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
