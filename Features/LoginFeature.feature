Feature: Login

@Sanity
Scenario: Succesful Login with Valid Credentials

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page title should be "Your store. Login"
And Close browser

@Regression
Scenario Outline: Succesful Login with Valid Credentials DDT

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and Password as "<password>"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page title should be "Your store. Login"
And Close browser

Examples:
|email|password|
|admin@yourstore.com|admin|
|Test@yourstore.com|admin|