import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

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

    @AfterTest
    public void cleanUp () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
