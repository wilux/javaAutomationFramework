package tests.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static tests.utils.BrowserSelector.selectBrowser;

public class BaseStep {
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
