Feature: Customers
  Background:
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard

  Scenario: Add new Customer
    When User click on customers menu
    And click on customers menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser

  Scenario: Search Customer by emailID
    When User click on customers menu
    And click on customers menu item
    And enter customer email
    When click on search button
    Then user should found email in the search table
    And close browser

   Scenario: Search Customer by Name
     When User click on customers menu
     And click on customers menu item
     And enter customer firstname
     Then click on search lastname
     When click on search button
     Then user should found name in the search table
     And close browser