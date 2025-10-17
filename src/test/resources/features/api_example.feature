@api
Feature: API Testing Example
  Scenario: Validate GET request to JSONPlaceholder
    Given I send a GET request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200
    And the response should contain "userId"