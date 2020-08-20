Feature: GET Requests
  Verify that the API can return the correct information
  Scenario: List users
    Given users exist in the system on page 2
    When user requests the list of all users on page 2
    Then return the list of users on page 2
    And the user list has the correct schema
    And status code is 200
    
  Scenario: Get single user
    Given users exist in the system with id of 2
    When user requests the user with id of 2
    Then return the data for user with id of 2
    And the email address is 'janet.weaver@reqres.in'
    And status code is 200
    
  Scenario: User does not exist
    Given users exist in the system with id of 23
    When user requests the user with id of 23
    Then status code is 404
    
    