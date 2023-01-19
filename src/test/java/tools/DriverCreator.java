package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCreator {

    public static WebDriver getDriver(String browser) {

        if (browser.equals("chrome")) {

            return getchromeDriver();

        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        }

        return getchromeDriver();

    }

    public static ChromeDriver getchromeDriver() {

        WebDriverManager.chromedriver();

        ChromeOptions chromeOptions = new ChromeOptions();

        if (System.getProperty("os.name").contains("Mac")) {
            chromeOptions.setBinary("/Applications/Google Chrome/Google Chrome.app/Contents/MacOS/Google Chrome");
        }

        return new ChromeDriver(chromeOptions);

    }

}
