package tests.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class BrowserSelector {

    public static final int TIME_OUT = 5;

    public static WebDriver selectBrowser(String browserName, String[] options) {
        if (browserName == null || browserName.isEmpty()) {
            browserName = "firefox";
        }
        browserName = browserName.toLowerCase();

        WebDriver driver;
        switch (browserName) {
            case "firefox":
                driver = createFirefoxDriver(options);
                break;
            case "chrome":
                driver = createChromeDriver(options);
                break;
            case "edge":
                driver = createEdgeDriver(options);
                break;
            case "opera":
                driver = createOperaDriver(options);
                break;
            default:
                throw new UnsupportedOperationException("Browser not supported: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createFirefoxDriver(String[] options) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(options);
        firefoxOptions.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createOperaDriver(String[] options) {
        WebDriverManager.operadriver().setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments(options);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("w3c", true);
        capabilities.setCapability("disable-extensions", true);
        return new OperaDriver(operaOptions);
    }

    private static WebDriver createChromeDriver(String[] options) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(options);
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createEdgeDriver(String[] options) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(options);
        edgeOptions.setCapability(ChromeOptions.CAPABILITY, edgeOptions);
        return new EdgeDriver(edgeOptions);
    }

}
