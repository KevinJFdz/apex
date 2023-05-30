package pages.base.page.actions;

import org.openqa.selenium.*;

public class StatusElementActions {

    private final WebDriver driver;
    private final WaitsActions waitsActions;

    public StatusElementActions(WebDriver driver, WaitsActions waitsActions) {
        this.driver = driver;
        this.waitsActions = waitsActions;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element, int secondsToWait) {
        waitsActions.setImplicitlyWaitTime(secondsToWait);
        boolean isElementDisplayed;
        try {
            isElementDisplayed = element.isDisplayed();
            waitsActions.resetImplicitlyWait();
            return isElementDisplayed;
        } catch (NoSuchElementException e) {
            waitsActions.resetImplicitlyWait();
            return false;
        }
    }
}