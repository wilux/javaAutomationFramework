Executing Tests with Selenium, Java, and TestNG

This document outlines how to execute automated tests written with Selenium, 
Java, and the TestNG testing framework from the command line.

### Prerequisites
* Before proceeding, ensure you have the following installed and configured on your system:
* Java Development Kit (JDK): Verify the version using java -version in your terminal.
* Apache Maven: Verify the version using mvn -version in your terminal.

## Running the Tests
Navigate to Project Directory: Open a command prompt or terminal and navigate to your project's directory.


#### Browser selector & Options

mvn test -Dbrowser=firefox -Doptions=--headless

#### All Test Methods Default

mvn test
