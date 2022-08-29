Feature: table columns names
  @table_columns
  Scenario: Table columns names
    Given user is on the login page
    And user login as a librarian
    And user click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |