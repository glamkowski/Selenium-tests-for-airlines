package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResults {

    @FindBy(xpath = "//h4//b")
    List<WebElement> hotels;

    public SearchResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getHotelNames() {
        Stream<WebElement> streamHotelNames = hotels.stream();
        return streamHotelNames
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
