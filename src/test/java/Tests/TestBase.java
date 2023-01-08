package Tests;

import Pages.HomePage;
import Pages.SearchResults;
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

    HomePage homePage;
    SearchResults searchResults;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (System.getProperty("os.name").contains("Mac")) {
            chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
        }

        driver = new ChromeDriver(chromeOptions);

        homePage = new HomePage(driver);
        searchResults = new SearchResults(driver);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl");


    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
