Feature: A user can successfully create an account

  Scenario: Visit the fashion website and create an account

    Given I go to the fashion url 'http://automationpractice.com/index.php'
    When I click on Sign In
    And I enter a valid email 'bhandari1982' timestamp '@hotmail.com'
    And I click Create an account
    When I enter the personal details
      |Title | FirstName |LastName |Password | Date |Month | Year |Address        |City |State  |ZipCode |Country       |Mobile      |
      |Mrs   | Bob       |Baggins  |dragon   | 18   |March | 1982 |101 The Shires |Adak |Alaska |35242   |United States |07788877678 |
    And Click Register
    Then A new account should be created successfully

