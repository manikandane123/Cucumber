#Author: Mani List of List Program

@tag
Feature: Using List of List pass the values
  I want to use this template for my feature file

  @tag1
  Scenario: List of List pass the username and password
    Given Open the Demoguru home page
    When Pass the username and password values
    |user1|pass1|
    |user2|pass2|
    |user3|pass3|
    |user4|pass4|
    And Reset the value
    Then I validate the expected outcomes

