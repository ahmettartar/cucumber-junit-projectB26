
@bear1
Feature:  Order process
  User Story: As a user, I should be able to place order

#TC#4: SmartBear order process PARAMETERIZATION

  Scenario: As a user I should see myself on the list after placing an order
    Given user is logged into SmartBear Tester account and on Order page
      | Username | Tester |
      | Password | test   |
    When user fills out the form as followed:
    And user selects "FamilyAlbum" from product dropdown
    Then user enters 4 to quantity
    And user enters "John Wick" to costumer name
    Then user enters "Kinzie Ave" to street
    And user enters "Chicago" to city
    Then user enters "IL" to state
    And user enters 60056
    Then user selects "Visa" as card type
    And user enters "1111222233334444" to card number
    Then user enters "12/22" to expiration date
    When user clicks process button
    Then user verifies "John Wick" is in the list