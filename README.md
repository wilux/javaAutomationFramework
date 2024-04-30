Executing Tests with Selenium, Java, and TestNG

This document outlines how to execute automated tests written with Selenium, 
Java, and the TestNG testing framework from the command line.

### Prerequisites
* Before proceeding, ensure you have the following installed and configured on your system:
* Java Development Kit (JDK): Verify the version using java -version in your terminal.
* Apache Maven: Verify the version using mvn -version in your terminal.

## Running the Tests
Navigate to Project Directory: Open a command prompt or terminal and navigate to your project's directory.


#### Individual Test Methods: Execute a specific test method within a class using

mvn test -Dtest=MyTestClass#testMethod1


#### All Test Methods

mvn test
