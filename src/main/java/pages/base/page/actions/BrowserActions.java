package pages.base.page.actions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserActions {
    private static WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public byte[] takeScreenshot(WebElement elementToTakeScreenShoot) {
        return elementToTakeScreenShoot.getScreenshotAs(OutputType.BYTES);
    }
}
