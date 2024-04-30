package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AppTest {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    void myTest() {

        driver.get("https://www.google.com");
        
//        String url = driver.getCurrentUrl();
//        assertTrue(url.contains("google"));

    }
    @AfterTest
    void tearDown() {
        driver.quit();
    }
}