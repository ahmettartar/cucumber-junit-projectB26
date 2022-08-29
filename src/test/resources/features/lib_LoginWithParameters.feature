@login_with_parameters
Feature: Library app login feature
  User Story: As a user, I should be able to login with correct credentials
  to different accounts
  Background: Assuming user is on the login page
    Given user is on the login page
  @librarian @employee
  Scenario: Login as librarian
    When user enters "librarian1_login" username
    And user enters "librarian1_password" password
    Then user should see the dashboard
  @student
  Scenario: Login as student
    When user enters "student1_login" username
    And user enters "student1_password" password
    Then user should see the dashboard
  @users_number
  Scenario for Task4
  Scenario: Login as librarian same line
    When user login using "librarian1@library" and "rs4BNN9G"
    Then user should see the dashboard page
    And there should be 138 users