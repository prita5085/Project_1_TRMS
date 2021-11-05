#This is a comment in a Feature file
Feature: Login Page of TRMS

#Each Scenario will correspond to a User Story
Scenario: Successful login with valid credentials
	Given User is on login page
	When User enters username and password
	And User click on login button
	Then User should be on the employee dashboard