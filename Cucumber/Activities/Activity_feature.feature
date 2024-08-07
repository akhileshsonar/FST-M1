
Feature: First Test

@activity1
Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Search current date
    And Close the browser