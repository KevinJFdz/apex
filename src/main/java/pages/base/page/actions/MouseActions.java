package pages.base.page.actions;

import org.openqa.selenium.*;

import java.util.List;

public class MouseActions {

    private final WebDriver driver;
    private final FindElementActions findElementActions;
    private final WaitsActions waitsActions;
    private final StatusElementActions statusElementActions;

    public MouseActions(WebDriver driver, FindElementActions findElementActions, WaitsActions waitsActions, StatusElementActions statusElementActions) {
        this.driver = driver;
        this.findElementActions = findElementActions;
        this.waitsActions = waitsActions;
        this.statusElementActions = statusElementActions;
    }

    public void click(WebElement element) {
        try {
            waitsActions.waitToElementBeClickable(element);
            element.click();
        } catch (StaleElementReferenceException exception) {
            click(element);
        }
    }

    public void click(WebElement element, boolean waitToBeClickable) {
        try {
            if (waitToBeClickable) {
                click(element);
            } else {
                element.click();
            }
        } catch (StaleElementReferenceException exception) {
            click(element, waitToBeClickable);
        }
    }

    public void click(WebElement element, By locator, boolean waitToBeClickable) {
        WebElement elementToClick = findElementActions.findElement(element, locator);
        click(elementToClick, waitToBeClickable);
    }
}