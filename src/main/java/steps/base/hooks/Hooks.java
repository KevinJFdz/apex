package steps.base.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.base.page.BasePage;
import support.cucumber.CucumberManager;
import support.selenium.DriverManager;

public class Hooks {
    @Before(order = 10)
    public void setUp(Scenario scenario) {
        CucumberManager.setScenario(scenario);
        BasePage.setDriver(DriverManager.getWebDriver());
    }

    @After(order = 20)
    public void tearDown() {
        CucumberManager.attachScreenshotToReport();
        BasePage.quitDriver();
    }
}
