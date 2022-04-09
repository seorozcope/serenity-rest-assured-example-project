Feature: as SysAdmin I need to manage users to allow end users sign in the app

  Scenario: POST - Register a single user account providing required data
    Given the SysAdmin wants to register a single user
    When the SysAdmin attempts to request user registration providing all required data
    Then SysAdmin should receive a successful response

  Scenario: POST - Register a single user account missing required data
    Given the SysAdmin wants to register a single user
    When the SysAdmin attempts to request user registration missing all required data
    Then SysAdmin should receive a bad request response

  Scenario: POST - Create a single user
    Given the SysAdmin wants to create a single user
    When the SysAdmin attempts to request user creation providing all user data
    Then SysAdmin should receive a user created successful response

  Scenario: PUT - Update all user data
    Given the SysAdmin wants to update all data for a single user
    When the SysAdmin attempts to request user update providing all user data
    Then SysAdmin should receive a user updated successful response

  Scenario: PATCH - Update some user data
    Given the SysAdmin wants to update some data for a single user
    When the SysAdmin attempts to request user update providing some user data
    Then SysAdmin should receive a user updated successful response

  Scenario: DELETE - Remove a user from users list
    Given the SysAdmin wants to delete a single user
    When the SysAdmin attempts to request user deletion providing user id
    Then SysAdmin should not be able to request for that user again

