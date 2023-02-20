Feature: MakeMyTrip Test Caces

Scenario: MakeMyTrip Page
	Given User navigate to MakeMyTrip Page
	Then MakeMyTrip page is displayed
	When User Click on Flights
	Then User Enter City From
	And User Enter City To
	When Select departure date
	And Click on search button