package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        Stream<WebElement> streamHotelNames = hotels.stream();
        return streamHotelNames
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
