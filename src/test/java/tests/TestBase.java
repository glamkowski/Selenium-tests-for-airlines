package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.AccountPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignupPage;
import tools.DriverCreator;
import tools.PropertiesLoader;

import java.io.File;
import java.io.IOException;

public class TestBase {

    public WebDriver driver;
    public static final Logger logger = LogManager.getLogger();
    HomePage homePage;
    SearchResultsPage searchResults;
    SignupPage signupPage;
    AccountPage accountPage;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;

    @BeforeSuite
    public void beforeSuite() {
        File file = new File("src/java/recources/raport.html");

        htmlReporter = new ExtentHtmlReporter(file);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite () {
        htmlReporter.flush();
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() throws IOException {

        String browserName = PropertiesLoader.getProperty("browser.name");

        driver = DriverCreator.getDriver(browserName);
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl");

        accountPage = new AccountPage(driver);
        homePage = new HomePage(driver);
        searchResults = new SearchResultsPage(driver);
        signupPage = new SignupPage(driver);

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
