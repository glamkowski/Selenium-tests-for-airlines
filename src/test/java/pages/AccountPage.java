package pages;

import tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {

    public WebDriver driver;

    @FindBy (css = "h3.RTL")
    WebElement hiHeader;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHiHeader () {
        return hiHeader.getText();
    }

}
