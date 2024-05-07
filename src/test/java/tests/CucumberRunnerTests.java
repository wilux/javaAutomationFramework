package tests;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import static tests.utils.BrowserSelector.selectBrowser;
@RunWith(Cucumber.class)
@CucumberOptions(tags = "", features = {"src/test/resources/features"}, glue = {"src/test/java/tests/steps"},
        plugin = {})


public class CucumberRunnerTests {

    public static WebDriver driver;

    @Before
    public void setup() {
        String browserName = System.getProperty("browser");
        String options = System.getProperty("options");
        String[] optionsList = null;
        if (options != null) {
            optionsList = options.split(",");
        }
        driver = selectBrowser(browserName, optionsList);

    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}