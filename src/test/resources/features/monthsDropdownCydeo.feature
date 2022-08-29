@MonthDropdown
Feature: months displayed in month dropdown
  User Story: As a user, I should be able to see all 12 month in month dropdown
  Scenario: User should be able to see all 12 months in months dropdown
    Given user is on the dropdowns page of practice tool
    Then user should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |