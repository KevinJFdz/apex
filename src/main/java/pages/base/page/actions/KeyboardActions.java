package pages.base.page.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    private final WebDriver driver;
    private final WaitsActions waitsActions;

    public KeyboardActions(WebDriver driver, WaitsActions waitsActions) {
        this.driver = driver;
        this.waitsActions = waitsActions;
    }

    public void enter(WebElement element, String text) {
        waitsActions.waitToElementBeClickable(element);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void type(WebElement element, String text) {
        waitsActions.waitToElementBeClickable(element);
        element.sendKeys(text);
    }
}