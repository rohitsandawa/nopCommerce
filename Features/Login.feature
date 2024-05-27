Feature: Login 

@sanity
Scenario: Successful Login with Valid Credentials 

	Given User launch chrome browser 
	When User open Url "https://admin-demo.nopcommerce.com/login" 
	And Users Enter email as "admin@yourstore.com" and password as "admin" 
	And click on login 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When User click on logout link
	And close browser
	
@regression	
Scenario Outline: Successful Login with Valid Credentials 

	Given User launch chrome browser 
	When User open Url "https://admin-demo.nopcommerce.com/login" 
	And Users Enter email as "<email>" and password as "<password>" 
	And click on login 
	Then Page title should be "Dashboard / nopCommerce administration" 
	When User click on logout link
	And close browser
	
	Examples:
	     |email | password|
	     |admin@yourstore.com| admin|
	     |admin1@yourstore.com| admin123|	  
	       