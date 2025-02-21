Feature: E2E Cards

  @CardsSuite
  Scenario: As a user I want to examine each card while scrolling down so that I can go back to the top
    Given I am at the "main" page
    When I want to examine all cards
    Then I want to review the name, image and link of each of them
    # TOP BUTTON CASE
    And I scroll down to the bottom
    And I click on the top button to go to the top of the page
    Then I see the top label of the home page

  @CardsSuite
  Scenario: As a user I want to navigate to the first card so that I return to the home page
    Given I am at the "main" page
    When I click on the details of the first card
    Then I see the details of the first card
    # HOME BUTTON CASE
    And I click on the home button to go to the home page
    Then I see the home page

  @CardsSuite
  Scenario: As a user I want to click on the add button so that I can create a new card
    Given I am at the "main" page
    When I click on the add button to go to the card creation page
    Then I see a form with fields to create a new card