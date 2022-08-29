@wikipedia
Feature: Wikipedia Search Functionality

  Background:
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button

  Scenario: TC#2: Wikipedia Search Functionality Title Verification
    Then User sees "Steve Jobs" is in the wiki title


  Scenario: TC#3: Wikipedia Search Functionality Header Verification
    Then User sees "Steve Jobs" is in the main header


  Scenario: TC#4: Wikipedia Search Functionality Image Header Verification
    Then User sees "Steve Jobs" is in the image header