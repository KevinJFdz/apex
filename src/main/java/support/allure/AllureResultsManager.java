package support.allure;

import io.qameta.allure.ConfigurationBuilder;
import io.qameta.allure.ReportGenerator;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class AllureResultsManager {
    static void copyCurrentAllureResultsToAllureResultsHistory(String allureResultDir, String allureResultsHistoryDir) throws IOException {
        File allureResults = new File(allureResultDir);
        File allureHistory = new File(allureResultsHistoryDir);
        FileUtils.copyDirectory(allureResults, allureHistory);
    }

    public static void generateAllureHtmlReport(String allureHtmlReportOutputDir, String allureResultsDir) {
        try {
            ReportGenerator reportGenerator = new ReportGenerator(new ConfigurationBuilder().useDefault().build());
            FileUtils.deleteDirectory(new File(allureHtmlReportOutputDir));
            reportGenerator.generate(Path.of(allureHtmlReportOutputDir), Path.of(allureResultsDir));
        } catch (Exception ignored) {
        }
    }


}