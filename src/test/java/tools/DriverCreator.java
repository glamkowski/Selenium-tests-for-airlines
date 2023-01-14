package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCreator {

    public static WebDriver getDriver(String browser) {


        if (browser == "chrome") {

            WebDriverManager.chromedriver();

            ChromeOptions chromeOptions = new ChromeOptions();

            if (System.getProperty("os.name").contains("Mac")) {
                chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
            }

            return new ChromeDriver(chromeOptions);

        }

        else if (browser == "edge") {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }

        else if (browser == "safari") {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        }

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }


}
