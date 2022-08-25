package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

import static utils.BasePage.getDriver;

public class CategoriesPage {
    public CategoriesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css="button[class*='dropdown']")
    private WebElement vehiclesDropdown;

    @FindBy(xpath="//*[text()= 'Autos y Camionetas']/parent::div")
    private WebElement vehiclesOption;

    @FindBy(xpath="button[class*='search-desktop']")
    private WebElement searchButton;


    public SearchResultPage selectCategorySearchFilters() {
        SeleniumUtils.waitAndClick(getDriver(), vehiclesDropdown, 10);
        SeleniumUtils.waitAndClick(getDriver(), vehiclesOption, 10);
        SeleniumUtils.waitAndClick(getDriver(), searchButton, 10);
        return new SearchResultPage();
    }

}
