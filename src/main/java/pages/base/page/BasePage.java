package pages.base.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.base.page.actions.*;
import support.selenium.DriverManager;

public class BasePage {
    private static WebDriver driver;
    public static BrowserActions browserActionsPage;
    protected FindElementActions findElementActions;
    protected ElementInformationActions elementInformationActions;
    protected KeyboardActions keyboardActions;
    protected MouseActions mouseActions;
    protected StatusElementActions statusElementActions;
    protected WaitsActions waitsActions;

    public BasePage() {
        PageFactory.initElements(driver, this);
        browserActionsPage = new BrowserActions(driver);
        findElementActions = new FindElementActions(driver);
        waitsActions = new WaitsActions(driver, findElementActions);
        keyboardActions = new KeyboardActions(driver, waitsActions);
        statusElementActions = new StatusElementActions(driver, waitsActions);
        elementInformationActions = new ElementInformationActions(driver, findElementActions, waitsActions, statusElementActions);
        mouseActions = new MouseActions(driver, findElementActions, waitsActions, statusElementActions);
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public String getEnvironment() {
        return DriverManager.getEnvironment();
    }

    public static void quitDriver() {
        driver.quit();
    }
}
