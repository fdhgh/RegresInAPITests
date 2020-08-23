# RegresInAPITests

Automated Test Suite for https://reqres.in/ using Cucumber and Rest Assured. This suite covers ‘happy path’ tests for each of the CRUD actions of the Regres API. The tests response is checked for the correct information based on the request, as well as a generic response time check.

## General Info

This project uses:

* Maven - Dependency management and build tool
* RestAssured - API test tool http://rest-assured.io/
* JUnit - Test framework https://junit.org/junit4/
* Cucumber - BDD framework https://cucumber.io/

Written in Java 11 in Eclipse IDE.

Feature test steps are defined in the feature files: src\test\java\features

## Getting Started
### Running the tests

To run all tests, run the project as a Maven test:
````mvn test````

## Reporting

HTML report is produced at the end of each run and saved to target/htmlreports

Future improvements:
* The check on createdAt/updatedAt fields could be improved by checking against the current datetime and/or an acceptable datetime format
* Expand scope of testing. The current tests are happy path and do not cover negative scenarios (e.g. invalid parameters).
* Performance testing. Currently there is only one generic performance test (response time). There is no load testing, though this might be better accomplished using another tool such as JMeter or Gatling.
* Check for and remove any test dependencies e.g. where one test must follow another.
* JUnit version: This uses JUnit 4, so could be upgraded. This may require some refactoring of deprecated methods.
