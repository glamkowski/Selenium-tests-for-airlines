package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.SeleniumHelper;

import java.io.IOException;
import java.util.stream.Collectors;


public class HotelSearch extends TestBase {

    @Test
    public void shouldFindHotels() {

        ExtentTest test = extent.createTest("Should find hotel");

        homePage.setCity("Dubai");
        test.log(Status.PASS, "Setting city done");
        homePage.setStartDate(homePage.getDateInNthDays(2));
        test.log(Status.PASS, "Setting start date done");
        homePage.setTravellers("3", "2");
        test.log(Status.PASS, "Setting travellers done");
        homePage.clickSearchButton();

        Assert.assertEquals(searchResults.getHotelNames()
                .stream()
                .filter(e -> e.equals("Oasis Beach Tower"))
                .collect(Collectors.toList()).get(0), "Oasis Beach Tower");

        Assert.assertEquals(searchResults.getHotelNames()
                .stream()
                .filter(e -> e.equals("Hyatt Regency Perth"))
                .collect(Collectors.toList()).get(0), "Hyatt Regency Perth");

        test.log(Status.PASS, "Assertions passed");

    }

    @Test
    public void shouldNotFindHotels() throws IOException {

        ExtentTest test = extent.createTest("Should not find hotels");

        homePage.setStartDate(homePage.getDateInNthDays(2));
        test.log(Status.PASS, "Setting start date done");
        homePage.setTravellers("1", "1");
        test.log(Status.PASS, "Setting travellers done");
        homePage.clickSearchButton();
        Assert.assertEquals(homePage.getTextFromElement(homePage.noResultsFoundText), "No Results Found");
        test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.getScreenshot(driver)).build());
    }
}
