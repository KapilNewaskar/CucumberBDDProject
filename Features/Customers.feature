Feature: Customers

Background: Steps common for all scenarios

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then User can view Dashboard


@Sanity
Scenario: Add new customer


When User click on customer menu
And Click on customers menu item
And Click on add new button
Then User can view add new customer page
When User enter customer info
And Click on save button
Then User can view confirmation message "The new customer has been added successfully."
And Close browser


@Regression @sanity
Scenario: Search customer by Email

When User click on customer menu
And Click on customers menu item
And Click on customer Email
When Click on search button
Then User should found email in the search table
And Close browser