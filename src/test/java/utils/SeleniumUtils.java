package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public abstract class SeleniumUtils {

    static final Logger log = LoggerFactory.getLogger(SeleniumUtils.class);

    public static Boolean waitForElementBeClickable(WebDriver driver, WebElement element, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
            return TRUE;
        }catch(NoSuchElementException | TimeoutException e) {
            return FALSE;
        }
    }

    public static void waitAndClick(WebDriver driver, WebElement element, int seconds) {
        if (waitForElementBeClickable(driver, element, seconds)) {
            element.click();
        }else {
            log.info("The element could not be clicked after "+ seconds+ " seconds.");
        }
    }

    public static Boolean waitForElementToBeVisible(WebDriver driver, WebElement element, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
            return TRUE;
        } catch (NoSuchElementException | TimeoutException e) {
            return FALSE;
        }
    }

    public static Boolean waitForElementByLocator(WebDriver driver, By locator, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return TRUE;
        } catch (NoSuchElementException | TimeoutException e) {
            return FALSE;
        }
    }

    public static void sendKeys(WebDriver driver, WebElement element, int seconds, String keysToSend) {
        waitForElementToBeVisible(driver, element, seconds);
        element.clear();
        element.sendKeys(keysToSend);
    }

    public static void mouseOver(WebDriver driver, WebElement element, int seconds) {
        waitForElementToBeVisible(driver, element, seconds);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void scrollToElement(WebDriver driver, WebElement element, int seconds) {
        waitForElementToBeVisible(driver, element, seconds);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
