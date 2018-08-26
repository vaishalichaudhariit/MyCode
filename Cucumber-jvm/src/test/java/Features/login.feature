Feature: Free CRM Login Feature
# without Examples Keyword

#Scenario: Free CRM Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "vaishalic" and "vaishalic"
#Then user clicks on login button
#And user is on home page

#with Examples Keyword
Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then close the browser

Examples:
    | username | password |
    | naveenk  | test@123 |
    |   tom    | test@456 |
    | vaishalic| vaishalic|
#Scenario: Create a New Contact Test Scenario
#
#Given user is already on home Page
#When user mouse over on contacts link
#Then user clicks on New Contact link
#Then user enters firstname and lastname
#Then user click on save button
#Then verify new contact created