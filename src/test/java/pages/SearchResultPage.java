package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import static utils.BasePage.getDriver;
import static utils.SeleniumUtils.*;

public class SearchResultPage {
    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    static final Logger log = LoggerFactory.getLogger(SearchResultPage.class);

    String filtersApplied = "(//*[contains(@class, 'ui-search-applied-filters__link')])[INDEX]";
    @FindBy(css = ".ui-search-filter-range--price")
    private WebElement priceFiltersContainer;

    @FindBy(css = "[data-testid='Maximum-price']")
    private WebElement maxPriceInput;

    @FindBy(css = "[data-testid='submit-price']")
    private WebElement submitPriceButton;

    @FindBy(css = "[class*='search-filter'] [href*='cordoba']")
    private WebElement locationFilter;

    @FindBy(css = "[class*='search-sort'] button")
    private WebElement sortFilter;

    @FindBy(css = "[data-key='price_asc']")
    private WebElement sortByPriceAsc;

    @FindBys({@FindBy(css = ".price-tag-text-sr-only")})
    private List<WebElement> priceList;

    @FindBys({@FindBy(css = ".ui-search-item__title")})
    private List<WebElement> itemsTitleList;


    public void selectSearchFilters(String maxPriceValue) {
        scrollToElement(getDriver(), priceFiltersContainer, 10);
        sendKeys(getDriver(), maxPriceInput, 5, maxPriceValue);
        waitAndClick(getDriver(), submitPriceButton, 5);
        waitForElementByLocator(getDriver(), By.xpath(filtersApplied.replace("INDEX", "1")), 10);
        waitAndClick(getDriver(), locationFilter, 5);
        waitForElementByLocator(getDriver(), By.xpath(filtersApplied.replace("INDEX", "2")), 10);
        waitAndClick(getDriver(), sortFilter, 5);
        waitAndClick(getDriver(), sortByPriceAsc, 5);
    }

    public void printItemsTitle() {
        for (WebElement item : itemsTitleList) {
            log.info(item.getText());
        }
    }

    public boolean ascOrder() {
        List<Double> prices = new ArrayList<>();
        List<Double> orderedList = new ArrayList<>();
        for (WebElement item : priceList) {
            String[] priceData = item.getText().split(" ");
            String price = priceData[0];
            String currency = priceData[1];
            Double finalPrice = Double.parseDouble(price);
            if (currency.equals("dólares")) {
                finalPrice = finalPrice * 137;
            }
            prices.add(finalPrice);
            orderedList.add(finalPrice);
        }
        orderedList.sort(null);
        return prices.equals(orderedList);
    }

}
