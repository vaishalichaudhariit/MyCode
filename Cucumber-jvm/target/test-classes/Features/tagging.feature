@FuntionalTest
Feature: Free CRM application testing

@SmokeTest @RegressionTest
Scenario: Login with correct username and correct password
Given This is a valid login test

@RegressionTest
Scenario: Login with incorrect username and correct password
Given This is a invalid login test

@SmokeTest
Scenario: Create a contact
Given This is a contact test case

@RegressionTest
Scenario: Create a Deal
Given This is a deal test case

@SmokeTest
Scenario: Create a tasks
Given This is a tasks test case

@RegressionTest
Scenario: Create a case
Given This is a case test case

@SmokeTest
Scenario: Verify left panel links
Given clicking on left panel links

@RegressionTest
Scenario: Search a deal
Given This is a search deal test

@SmokeTest @RegressionTest
Scenario: Search a contact
Given This is a search contact test

@End2End
Scenario: Search a case
Given This is a search case test

@SmokeTest @RegressionTest
Scenario: Search a task
Given This is a search task test

@End2End
Scenario: Search a call
Given This is a search call test


@End2End
Scenario: Search a email
Given This is a search email test

@SmokeTest
Scenario: Search a docs
Given This is a search docs test

@RegressionTest
Scenario: Search a forms
Given This is a search forms test

@SmokeTest @End2End
Scenario: Validate a report
Given This is a report test

@SmokeTest @RegressionTest @End2End
Scenario: Application Logout
Given This is a Logout test

Scenario: Close Browser
Given This is close browser test

