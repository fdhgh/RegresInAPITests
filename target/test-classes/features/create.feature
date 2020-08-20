Feature: Create a user
  Verify that the API can handle a Create request
  Scenario: Create User
    Given a user name and job title
    When user sends the create request
    Then return the new user name
    And return the new user job title
    And return the new user id
    And return the time the new record was created
    
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
    
    