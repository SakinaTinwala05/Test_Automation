Feature: Facebook Test Caces

Scenario: Facebook Login
    Given User navigate to Facebook Login Page
    Then Facebook login page is displayed with Email, Password, Login button, Forgotten account Link and Sign up for Facebook Link
    When User Enter email and Password
    And Click on login
    
