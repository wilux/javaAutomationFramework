package steps.hooks;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BrowserSelector;

import java.io.ByteArrayInputStream;


public class WebHooks {
    public static WebDriver driver;

    @Before("@web")
    public void setup() {
        String browserName = System.getProperty("browser");
        String options = System.getProperty("options");
        String[] optionsList = null;
        if (options != null) {
            optionsList = options.split(",");
        }
        driver = BrowserSelector.selectBrowser(browserName, optionsList);

    }

    @AfterStep("@web")
    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//        }
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @After("@web")
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
