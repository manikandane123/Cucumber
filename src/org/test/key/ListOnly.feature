#Author: Mani List Program


@tag
Feature: Using List to pass the values
  I want to use this template for my feature file

  @tag1
  Scenario: Demoguru using List and pass the value
    Given I want open the demoguru site
    When Pass the username and Password using List
      | username | password |
    And Click the reset button
    Then Check the outcomes
