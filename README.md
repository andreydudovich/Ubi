# Simple Rest api test

## Technologies & tools
Java 11, Cucumber 5, Allure 2, Junit 5, Maven, Lombok

## Run options
Note: before running test need to start Rest API server from https://github.com/andreydudovich/rest-api

### Run all tests and open allure report              
mvn clean test; mvn allure:serve 

#### Run tests with specific tag     
mvn test -Dcucumber.options="--tags @all"
##### or
mvn test -Dcucumber.options="--tags @get"
##### or
choose any tag from features/Books.feature

#### Run tests 
mvn test

## Parameters

#### Rerun failing tests
-Dsurefire.rerunFailingTestsCount=2