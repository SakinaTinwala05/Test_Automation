@InvalidLogin
Feature: Invalid Login Scenario

 Scenario: Planet Dashboard - InvalidLogin
    Given User navigate to Planet Dashboard Login Page
    When User Enter invalid email and Password
    And Click on login
    Then Below error message "You are not a part of a Planet Smart City enabled society. Please try out our demo login from the home screen" is displayed