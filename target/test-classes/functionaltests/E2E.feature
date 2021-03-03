
Feature: End to End Tests in Student API
Description: Functional testing of Student API

Scenario: User able to view all Student records in StudentApp
Given A list of students are available
When I get the details of students
Then Students details should be displayed with status code 200

Scenario: User is able to add Student details in StudentAPI
Given User should set the content type to json
When create the student record in student API 
Then student details created data fetched with status code 201