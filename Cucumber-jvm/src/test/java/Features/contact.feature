Feature: Free CRM Create Contacts

Scenario Outline: Free CRM Create a New Contact Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then user moves to new contact page
Then user enters contact details "<firstname>" and "<lastname>" and "<position>"
Then close the browser

Examples:
	| username | password | firstname | lastname | position |
	| naveenk  | test@123 | Tom1 	  | Peter1    | Manager  |
	| naveenk  | test@123 | David1 	  | Dsouza1   | Director |