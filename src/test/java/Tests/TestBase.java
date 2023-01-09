package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.SearchResultsPage;
import Pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    HomePage homePage;
    SearchResultsPage searchResults;
    SignupPage signupPage;

    AccountPage accountPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (System.getProperty("os.name").contains("Mac")) {
            chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
        }

        driver = new ChromeDriver(chromeOptions);


        homePage = new HomePage(driver);
        searchResults = new SearchResultsPage(driver);
        signupPage = new SignupPage(driver);
        accountPage = new AccountPage(driver);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl");

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
