package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SearchResultPage;
import utils.BasePage;

public class CodeChallengeTest extends BasePage {

    @Test
    public void CodeChallengeTest() throws InterruptedException {

       /*
       Complete the test cases according to the specifications described on the PDF sent by Email
       The Chrome Web driver is already configured, you are ready to work.
       */


        LandingPage landingPage= new LandingPage();
        HomePage homePage= landingPage.goToHomePage();
        CategoriesPage categoriesPage= homePage.goToVehiclesCategory();
        SearchResultPage searchPage = categoriesPage.selectCategorySearchFilters();
        searchPage.selectSearchFilters("2000000");
        searchPage.printItemsTitle();
        Assert.assertTrue(searchPage.ascOrder(), "The price of the results is not ordered as expected.");
    }


}
