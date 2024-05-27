Feature: Customers 

Background: below are the common steps for each scenario.
    Given User launch chrome browser 
	When User open Url "https://admin-demo.nopcommerce.com/login" 
	And Users Enter email as "admin@yourstore.com" and password as "admin" 
	And click on login 
    Then user can view Dashboard 
@sanity
Scenario: Add new customer 

	When user click on customer menu 
	And click on customer menu item 
	And click on Add new button 
	Then user can view add new customer page 
	When user enter customer info 
	And click on save button 
	Then user can view confirmation message "The new customer has been added successfully." 
	And close browser 
@regression	
Scenario: Search Customer by EmailID
    
    When user click on customer menu	
    And click on customer menu item
    And Enter customer EMail
    When Click on search button
    Then User should found Email in the Search table
    And  close browser

	