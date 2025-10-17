package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.hooks.WebHooks;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WebSteps {

    private WebDriver driver = WebHooks.driver;
    @Given("The user opens '{}'")
    @Step("The user opens '{url}'")
    public void openUrl(String url) {
        driver.get(url);
    }

    @Then("The user sees '{}' title")
    @Step("The user sees '{expectedTitle}' title")
    public void verifyPageTitle(String expectedTitle) {
        WebElement titleElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector( ".post-2715 > div:nth-of-type(1) h2")));
        assertEquals(expectedTitle, titleElement.getText());
    }

}