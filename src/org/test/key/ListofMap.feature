#Author: Mani List of Map Program
@tag
Feature: Using List of Map pass the values
  I want to use this template for my feature file

  @tag1
  Scenario: List of Map by pass the username and password
    Given I want to open the Demoguru home page
    When Pass the username and password using List of Map
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
      | user3    | pass3    |
      | user4    | pass4    |
    And Click reset button after pass the values
    Then I validate the expected values
