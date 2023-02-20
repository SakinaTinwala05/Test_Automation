Feature: Planet Back-office Test Caces

Scenario: Planet Back-office Login
    Given User navigate to Planet Dashboard Login Page
    Then Planet Dashboard login page is displayed with Email, Password, Login button and forgotpassword Link
    When User Enter email and Password
    And Click on login
    Then User will be redirected to Dashboard page
    
 Scenario: Planet Back-office Dashboard
 		Given User navigate to Planet Dashboard Login Page
    Then User login into Planet back-office and Dashboard page will be visible
    
    