package pages.base.page.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class WaitsActions {
    private WebDriver driver;
    private final FindElementActions findElementActions;

    public WaitsActions(WebDriver driver, FindElementActions findElementActions) {
        this.driver = driver;
        this.findElementActions = findElementActions;
    }

    public Wait getWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
    }

    public void waitToElementBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToElementBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToTextToBePresentInElement(WebElement element, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void setImplicitlyWaitTime(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void resetImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
