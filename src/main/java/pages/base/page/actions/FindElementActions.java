package pages.base.page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FindElementActions {
    private static WebDriver driver;


    public FindElementActions(WebDriver driver) {
        FindElementActions.driver = driver;
    }

    public WebElement findElement(WebElement element, By locator) {
        try {
            return element.findElement(locator);
        } catch (StaleElementReferenceException Exception) {
            return findElement(element, locator);
        }
    }

    public WebElement findElementInAListByContainsText(List<WebElement> elementList, String textToSearch) {
        try {
            for (WebElement element : elementList) {
                moveToElement(element);
                if (element.getText().contains(textToSearch)) {
                    return element;
                }
            }
        } catch (java.util.NoSuchElementException exception) {
            return null;
        } catch (StaleElementReferenceException exception) {
            return findElementInAListByContainsText(elementList, textToSearch);
        }
        return null;
    }

    public WebElement findElementInAListByContainsText(List<WebElement> elementList, By locator, String textToSearch) {
        return findElementInAListByContainsText(elementList, locator, textToSearch, false);
    }

    public WebElement findElementInAListByContainsText(List<WebElement> elementList, By locator, String textToSearch, Boolean moveToElement) {
        try {
            for (WebElement element : elementList) {
                if (moveToElement) moveToElement(element);
                if (element.findElement(locator).getText().equals(textToSearch)) {
                    return element;
                }
            }
        } catch (java.util.NoSuchElementException exception) {
            return null;
        } catch (StaleElementReferenceException exception) {
            return findElementInAListByContainsText(elementList, locator, textToSearch);
        }
        return null;
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.release().perform();
    }
}