Feature: Amazon Test Caces

Scenario: Amazon Page
	Given User navigate to Amazon Page
	Then Amazon page is displayed
	When User Click on All navigation Link
	And Click on Echo and Alexa
	Then Echo and Alexa manu page is displayed
	When User Click on Echo Dot (3rd Gen)
	And Click on Buy Now

Scenario: Amazon Login
	Given User navigate to Amazon Login Page
	Then Amazon login page is displayed with Email and Continue Link
	And Click on Continue 
	When User Enter Email
	And Click on Continue button
	Then Password page is displayed with Password and SignIn Link
	When User Enter Password
	And Click on SignIn
	