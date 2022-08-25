package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

import static utils.BasePage.getDriver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css="[data-testid='action:understood-button']")
    private WebElement acceptCookies;
    @FindBy(css=".nav-menu-list [href*='categorias']")
    private WebElement categoriesButton;

    @FindBy(css=".nav-menu-list [href*='vehiculos']")
    private WebElement vehiclesButton;


    public CategoriesPage goToVehiclesCategory() {
        SeleniumUtils.waitAndClick(getDriver(), acceptCookies, 5);
        SeleniumUtils.mouseOver(getDriver(), categoriesButton, 5);
        SeleniumUtils.waitAndClick(getDriver(), vehiclesButton, 5);
        return new CategoriesPage();
    }

}