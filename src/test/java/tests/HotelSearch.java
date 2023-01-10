package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class HotelSearch extends TestBase {

    @Test
    public void shouldFindHotels() {

        homePage.setCity("Dubai");
        homePage.setStartDate("13");
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

        homePage.setStartDate("14");
        homePage.setTravellers("1", "1");
        homePage.clickSearchButton();
        Assert.assertEquals(homePage.getTextFromElement(homePage.noResultsFoundText), "No Results Found");

    }


}
