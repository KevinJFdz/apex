package support.allure;

import support.selenium.Environment;

import java.io.IOException;
import java.util.Arrays;

public class AllureManager {
    private static final String allureResultsDir = "target/allure-results";
    private static final String allureHtmlReportDir = "target/allure-report";
    private static String allureHistoryDir = "test-output/%s/%s/reports/allure";
    private static String allureResultsHistoryDir = "/allure-history";
    private static String allureHtmlReportHistoryDir = "/allure-report";

    public static void setUpAllureResultsHistory(String browser, Environment environment) {
        setUpAllureResultsDir(browser, environment);
        AllureReportConfigurator.initializeAllureReport(browser, environment, allureResultsDir);
    }

    private static void setUpAllureResultsDir(String browser, Environment environment) {
        allureHistoryDir = String.format(allureHistoryDir, environment.name, browser);
        allureResultsHistoryDir = allureHistoryDir + allureResultsHistoryDir;
        allureHtmlReportHistoryDir = allureHistoryDir + allureHtmlReportHistoryDir;
        System.setProperty("allure.results.directory", allureResultsDir);
    }

    public synchronized static void allureTearDown() {
        generateCurrentAllureHtmlReport();
        copyCurrentAllureResultsToAllureHistory();
        generateAllureHtmlReportHistory();
    }

    public static void generateCurrentAllureHtmlReport() {
        AllureResultsManager.generateAllureHtmlReport(allureHtmlReportDir, allureResultsDir);
    }

    public static void copyCurrentAllureResultsToAllureHistory() {
        try {
            AllureResultsManager.copyCurrentAllureResultsToAllureResultsHistory(allureResultsDir, allureResultsHistoryDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateAllureHtmlReportHistory() {
        AllureResultsManager.generateAllureHtmlReport(allureHtmlReportHistoryDir, allureResultsHistoryDir);
    }
}
