package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

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
