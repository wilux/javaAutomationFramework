Executing Tests with Selenium, Java, and Cucumber

### Prerequisites
* Before proceeding, ensure you have the following installed and configured on your system:
* Java Development Kit (JDK): Verify the version using java -version in your terminal.
* Apache Maven: Verify the version using mvn -version in your terminal.

## Running the Tests
Navigate to Project Directory: Open a command prompt or terminal and navigate to your project's directory.


# Java BDD Automation Framework
* Note:
This is a basic automation framework that can be expanded upon as needed. It provides a solid foundation for building comprehensive test suites using Behave and Allure.

## Prerequisites:
### This automation framework requires the following tools:

* Java 8 or above: Download and install Python from [https://www.python.org/downloads/.](https://www.oracle.com/java/technologies/downloads/)
* Allure: A reporting framework for generating comprehensive test reports. Download/Install from https://allurereport.org/docs/install/


### Running Tests:
To execute the example test, use the following command:

```Bash
mvn test -Dbrowser=firefox -Doptions=--headless
``` 

### Explanation:
#### Specifies the browser to use:
```Bash
-Dbrowser=firefox 
``` 
 Supported browsers include firefox, chrome and edge. Default is chrome.

#### Specify options capabilities:
```Bash
-Doptions=--headless
``` 
```Bash
-Doptions=--headless,--option1,...
``` 


## Reporting
### Allure Reports:

The framework generates Allure reports in the allure.output directory. To view these reports, run the following command:

```Bash
allure serve allure-results
 ``` 
This will open a web browser with the generated Allure report.

### JUnit Reports:

The framework also generates JUnit reports in the reports directory. These reports are compatible with Jenkins and other CI/CD tools.

* Note:
This is a basic automation framework that can be expanded upon as needed. It provides a solid foundation for building comprehensive test suites using Behave and Allure.

#### Additional Resources:
* Cucumber documentation: https://cucumber.io/docs/installation/
* Allure documentation: https://github.com/allure-framework
