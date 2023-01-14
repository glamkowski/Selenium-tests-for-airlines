package pages;

import org.openqa.selenium.By;
import tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.SeleniumHelper;

public class AccountPage extends TestBase {

    @FindBy (css = "h3.RTL")
    public WebElement hiHeader;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHiHeader () {
        SeleniumHelper.waitForElementExist(driver, By.cssSelector("h3.RTL"));
        return hiHeader.getText();
    }

}
