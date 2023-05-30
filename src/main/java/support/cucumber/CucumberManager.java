package support.cucumber;

import io.cucumber.java.Scenario;
import pages.base.page.BasePage;
import pages.base.page.actions.BrowserActions;

public class CucumberManager {
    public static void setScenario(Scenario newScenario){
        CucumberReport.setScenario(newScenario);
    }
    public static Scenario getScenario(){
        return CucumberReport.getScenario();
    }

    public static void attachScreenshotToReport(){
        CucumberReport.attachScreenshotToReport(BrowserActions.takeScreenshot());
    }
    public static void attachScreenshotToReport(String message){
        CucumberReport.attachScreenshotToReport(BrowserActions.takeScreenshot(), message);
    }

    public static void attachScreenshotToReport(String message, byte [] screenShoot){
        CucumberReport.attachScreenshotToReport(screenShoot, message);
    }

    public static void attachTextToReport(String name, String text){
        CucumberReport.attachTextToReport(name, text);
    }
    public static void attachJsonToReport(String name, String json){
        CucumberReport.attachJsonToReport(name, json);
    }
}
