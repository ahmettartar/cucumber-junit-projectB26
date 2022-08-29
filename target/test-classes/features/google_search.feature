
Feature: Google Search Functionality Title Verification
  User story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Background:
    Given User is on Google search page

   @smoke @googleSearch #working in progress Yeni baslayinca bu tagi kullanabiliriz.
  Scenario: Search functionality result title verification
    #Given User is on Google search page
    When User types apple in the google search box and clicks enter
    Then User sees apple – Google Search is in the google title


  Scenario: Search functionality result title verification
    #Given User is on Google search page YUKARIYA ALDIK
    When User types "apple" in the google search box and clicks enter
    Then User sees "apple – Google Search" is in the google title
    # "apple" seklinde eklenen {string} olarak step-defintionda gorunmektedir.
  # @When("User types {string} in the google search box and clicks enter")
  # Boylece bunu parametre olorak metod icinde gireriz.
