import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelSearch extends TestBase {

    @Test
    public void HotelSearch () throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://kurs-selenium.pl");

        driver.findElement(By.xpath("//span[@class='select2-chosen' and text()='Search by Hotel or City Name']")).click();

        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-match' and text()='Dubai']")));
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();

        driver.findElement(By.name("checkin")).click();

       List<WebElement> d19 = driver.findElements(By.xpath("//td[@class='day ' and text()='19']"));
       d19.stream()
               .filter(e -> e.isDisplayed())
               .findFirst()
               .ifPresent(e -> e.click());

       driver.findElement(By.cssSelector("input[name='travellers']")).click();

       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#adultInput")));
       WebElement adultInput = driver.findElement(By.cssSelector("#adultInput"));
       adultInput.clear();
       adultInput.sendKeys("7");

       WebElement childInput = driver.findElement(By.cssSelector("#childInput"));
       childInput.clear();
       childInput.sendKeys("3");

       driver.findElement(By.xpath("//button[text()=' Search']")).click();

       List<WebElement> hotels = driver.findElements(By.xpath("//h4//b"));
       Stream<WebElement> streamHotels = hotels.stream();
       List<String> hotelList = streamHotels.map(e -> e.getText()).collect(Collectors.toList());

        for (String hotel :hotelList) { System.out.println(hotel); }

        Assert.assertEquals(hotelList.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelList.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelList.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelList.get(3), "Hyatt Regency Perth");

    }



}
