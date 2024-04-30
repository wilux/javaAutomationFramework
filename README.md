Executing Tests with Selenium, Java, and TestNG
This document outlines how to execute automated tests written with Selenium WebDriver, Java, and the TestNG testing framework from the command line.

Prerequisites
Before proceeding, ensure you have the following installed and configured on your system:

Java Development Kit (JDK): Verify the version using java -version in your terminal.
Apache Maven: Verify the version using mvn -version in your terminal.
Selenium WebDriver JAR: Download the appropriate JAR for your browser and Java version. Include it in your project's classpath or as a Maven dependency.
TestNG JAR: Include it in your project's classpath or as a Maven dependency.
IDE (Optional): Consider using an IDE like IntelliJ IDEA or Eclipse for a more convenient development environment.
Setting Up Your Project
Project Structure: Organize your project with source code files, including Selenium test classes annotated with @Test.
TestNG Configuration (testng.xml): Create a testng.xml file to define your TestNG suite(s) and specify the test classes to execute. This file allows you to configure various aspects of your test runs.
Running the Tests
Navigate to Project Directory: Open a command prompt or terminal and navigate to your project's directory.
Compile the Project: Use the Maven command mvn clean compile to compile your Java source code and generate class files.
Execute All Tests: Execute all TestNG tests defined in your project using mvn test. This will run the tests specified in your testng.xml file.
Additional Options
Specific Test Classes: Run only specific test classes using the -Dtest=ClassName parameter. For example, to run MyTestClass:

mvn test -Dtest=MyTestClass
Individual Test Methods: Execute a specific test method within a class using -Dtest=ClassName#methodName:

mvn test -Dtest=MyTestClass#testMethod1
Test Reports: Generate HTML or XML test reports for analysis. Use -Dreports=html or -Dreports=xml along with mvn test. Reports are typically generated in the target/surefire-reports directory.

Example
Suppose your project has a MyTestClass.java file with a test method @Test testMyMethod(). Your testng.xml file includes this test class.

To execute this test from the command line, navigate to the project directory and run:

mvn test
This will compile the code, execute the testMyMethod() test, and generate an HTML test report in the target/surefire-reports directory.

Remember: Adjust the commands and parameters based on your project structure and test configuration. Refer to the official Maven and TestNG documentation for more advanced options and customization possibilities.
