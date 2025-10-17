package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.hooks.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MobileSteps {

    private WebDriver driver = WebHooks.driver;

    @Given("I open the ueno bank app")
    public void i_open_the_unobank_app() {
        // El driver ya se inicializa en Hooks con @Before("@mobile")
    }

    @Then("I should see the login screen")
    public void i_should_see_the_login_screen() {
        // Ejemplo: validar que aparece el campo "¿Qué estás pensando?"
        WebDriverWait wait = new WebDriverWait(MobileHooks.driver, Duration.ofSeconds(30));

        // Usar UiSelector con description
        WebElement feedElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator("new UiSelector().description(\"Te damos la bienvenida\")")
                )
        );


        assertNotNull(feedElement, "Login screen not visible, user might not be logged out");
    }
}