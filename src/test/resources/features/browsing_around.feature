
 Feature: Find all Owners
 
 Background:
 		Given I have opened the browser
    And I am on the home page
    
 

   @SmokeTest 
   Scenario: Find all owners 
   	And I open find owners 
  	 When I click find owners
   	 Then I should see the headings "Owners" on the page
   	
   	@RegressionTest 
   	Scenario Outline: Find random owner
   	And I open find owners 
   	 When I search owner "<ownerName>" 
   	 Then I get a message "has not been found"
   	 Examples:
   	 |ownerName|
   	 |xyz|
   	 
   	 @SmokeTest
   	 Scenario: Validate logo and home page menu exists
   	 Then I can view PetClinic logo and menu items "Home","Find owners","Veterinarians","Error"
   	 
   