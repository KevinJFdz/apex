package pages.base.page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementInformationActions {

    private final WebDriver driver;
    private final FindElementActions findElementActions;
    private final WaitsActions waitsActions;
    private final StatusElementActions statusElementActions;

    public ElementInformationActions(WebDriver driver, FindElementActions findElementActions, WaitsActions waitsActions, StatusElementActions statusElementActions) {
        this.driver = driver;
        this.findElementActions = findElementActions;
        this.waitsActions = waitsActions;
        this.statusElementActions = statusElementActions;
    }

    public String getText(WebElement element) {
        waitsActions.waitToElementBeVisible(element);
        return element.getText();
    }

    public String getText(WebElement element, By locator) {
        WebElement elementToGetValue = findElementActions.findElement(element, locator);
        return getText(elementToGetValue);
    }
}