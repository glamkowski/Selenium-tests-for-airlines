package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumHelper {

    public static String getScreenshot (WebDriver driver) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File file = screenshot.getScreenshotAs(OutputType.FILE);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();

        String path = "src/test/resources/" + now + ".png";

        FileUtils.copyFile(file, new File(path));

        return path;
    }

    private String getRandomNum() {
        Double random = Math.random()*1000;
        String str = "Screen" + random;
        return str;
    }

    public static void waitForElementExist(WebDriver driver, By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToBeVisible (WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(12));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElemetsToBeVisible(WebDriver driver, By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(12));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
