package runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import support.cucumber.BaseRunner;
import support.selenium.Environment;

@CucumberOptions(
        tags= ""
)

public class APEXRunner extends BaseRunner {
    @BeforeSuite
    public void setUp() {
        environment = Environment.STAG;
        browser ="chrome";
        headless = false;
    }
}

