Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Admin area demo"
    And close browser

  Scenario Outline: Login Data Driven
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Admin area demo"
    And close browser

    Examples:
      | email | password|
      | admin@yourstore.com | admin  |
      | admin1@yourstore.com | admin123 |