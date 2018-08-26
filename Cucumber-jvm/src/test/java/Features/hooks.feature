Feature: Free CRM app test 
`
# Hook is for pre and post condition to execute our test scenarios

@First
Scenario: Free CRM Create deal test 
	Given user is on deal page 
	When user fills the deals form 
	Then deal is created
	
@Second
Scenario: Free CRM Create contact test 
	Given user is on contact page 
	When user fills the contact form 
	Then contact is created
	
@Third
Scenario Outline: Free CRM Create mail test 
	Given user is on mail page 
	When user fills the mail form 
	Then mail is created
	Examples:
	|mail1|
	|mail2|
	|mail3|