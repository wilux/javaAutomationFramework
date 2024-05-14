package steps;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BrowserSelector;

import java.io.ByteArrayInputStream;


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

    @AfterStep
    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
