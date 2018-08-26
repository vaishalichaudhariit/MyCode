Feature: Deal Data Map Creation 

Scenario: Free CRM Deal Creation DataTable Map Test Scenario
# DataTable with Map - Parameterization
	Given user is already on Login Page 
	When title of login page is Free CRM 
	Then user enters username and password 
		| username | password |
		| naveenk | test@123 |
		
	Then user clicks on login button 
	Then user is on home page 
	Then user moves to new deal page 
	Then user enters deal details 
		| title | amount | probability | commission |
		| test deal | 1000| 50 | 10 |
		| test deal1 | 2000| 60 | 20 |
		| test deal2 | 3000| 70 | 30 |
	Then close the browser 
	
