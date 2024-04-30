package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AppTest {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    void myValidTest() {

        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        searchBar.sendKeys("pepe");
        searchBar.submit();

        WebElement searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        String pageText = searchResults.getText();
        assertTrue(pageText.toLowerCase().contains("pepe"));

    }

    @Test
    void myInvalidTest() {

        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        searchBar.sendKeys("pepe");
        searchBar.submit();

        WebElement searchResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        String pageText = searchResults.getText();
        assertTrue(pageText.toLowerCase().contains("nestor"));

    }
    @AfterTest
    void tearDown() {
        driver.quit();
    }
}