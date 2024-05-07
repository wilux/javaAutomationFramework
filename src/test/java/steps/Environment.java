package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserSelector;


public class Environment {
    public static WebDriver driver;

    @Before
    public void setup() {
        String browserName = System.getProperty("browser");
        String options = System.getProperty("options");
        String[] optionsList = null;
        if (options != null) {
            optionsList = options.split(",");
        }
        driver = BrowserSelector.selectBrowser(browserName, optionsList);

    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
