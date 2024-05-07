package tests.steps;

import org.openqa.selenium.WebDriver;
import tests.CucumberRunnerTests;
public class BaseStep {
    protected WebDriver driver;

    public BaseStep() {
        this.driver = CucumberRunnerTests.driver;
    }
}
