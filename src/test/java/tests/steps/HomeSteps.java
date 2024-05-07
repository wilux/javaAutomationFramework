package tests.steps;


import io.cucumber.java.en.Given;

public class HomeSteps extends BaseStep {

    public HomeSteps() {
    }


    @Given("^The user opens pepe")
    public void openUrl() {
        driver.get("https://www.globalsqa.com/demo-site/");
    }

//    @When("The user sees \"{expectedTitle}\" title")
//    public void verifyPageTitle(String expectedTitle) {
//        WebElement titleElement = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector( ".post-2715 > div:nth-of-type(1) h2")));
//        assertEquals(expectedTitle, titleElement.getText());
//    }

}