package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelReader;

import java.io.IOException;
import java.util.stream.Collectors;

public class HotelSearch extends TestBase {

    @Test
    public void shouldFindHotels() {

        homePage.setCity("Dubai");
        homePage.setStartDate(homePage.getDateInNthDays(2));
        homePage.setTravellers("3", "2");
        homePage.clickSearchButton();

        Assert.assertEquals(searchResults.getHotelNames()
                .stream()
                .filter(e -> e.equals("Oasis Beach Tower"))
                .collect(Collectors.toList()).get(0), "Oasis Beach Tower");

        Assert.assertEquals(searchResults.getHotelNames()
                .stream()
                .filter(e -> e.equals("Hyatt Regency Perth"))
                .collect(Collectors.toList()).get(0), "Hyatt Regency Perth");

    }

    @Test
    public void shouldNotFindHotels() {

        homePage.setStartDate(homePage.getDateInNthDays(2));
        homePage.setTravellers("1", "1");
        homePage.clickSearchButton();
        Assert.assertEquals(homePage.getTextFromElement(homePage.noResultsFoundText), "No Results Found");

    }

    @DataProvider (name = "dateFromExcel")
    public String[][] getDataFromExcel() throws IOException {
        return ExcelReader.getDataFromExcel();
    }

    @Test (dataProvider = "dateFromExcel")
    public void testingWithDataFromExcel (String name, String lastname, String phone) {
        System.out.println(name + " -- " + lastname + " -- " + phone);
    }



}
