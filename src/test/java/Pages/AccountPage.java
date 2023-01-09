package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {

    @FindBy (css = "h3.RTL")
    WebElement hiHeader;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHiHeader () {
        return hiHeader.getText();
    }

}
