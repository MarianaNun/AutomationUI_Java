package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

import static utils.BasePage.getDriver;


public class LandingPage {
    public LandingPage() {
        PageFactory.initElements(getDriver(), this);
    }
        @FindBy(css="li a")
        private WebElement goToArgentinianHomePage;


        public HomePage goToHomePage() {
            SeleniumUtils.waitAndClick(getDriver(), goToArgentinianHomePage, 10);
            return new HomePage();
        }

    }
