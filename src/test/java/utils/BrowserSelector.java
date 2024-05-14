package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class BrowserSelector {

    public static final int TIME_OUT = 5;

    public static WebDriver selectBrowser(String browserName, String[] options) {
        if (browserName == null || browserName.isEmpty()) {
            browserName = "chrome";
        }
        if (options == null || options.length == 0) {
            options = new String[]{"--a"};
        }
        browserName = browserName.toLowerCase();

        WebDriver driver = switch (browserName) {
            case "firefox" -> createFirefoxDriver(options);
            case "chrome" -> createChromeDriver(options);
            case "edge" -> createEdgeDriver(options);
            default -> throw new UnsupportedOperationException("Browser not supported: " + browserName);
        };

        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createFirefoxDriver(String[] options) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(options);
        firefoxOptions.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
        return new FirefoxDriver(firefoxOptions);
    }


    private static WebDriver createChromeDriver(String[] options) {
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
