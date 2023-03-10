package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.SeleniumHelper;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResultsPage extends TestBase {

    @FindBy(xpath = "//h4//b")
    List<WebElement> hotels;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getHotelNames() {

        Actions actions = new Actions(driver);
        actions.moveToElement(hotels.get(hotels.size()-1));
        actions.perform();

        SeleniumHelper.waitForElemetsToBeVisible(driver, By.xpath("//h4//b"));



        Stream<WebElement> streamHotelNames = hotels.stream();
        return streamHotelNames
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
