package stepdefs;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.omg.CORBA.TRANSACTION_MODE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BrowsingAround {

	String petClinicURL="http://localhost:8080/petclinic";
	
	 WebDriver driver = null; 
	
	 @Before
	 public void initDriver()
	 {
		 System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//SeleniumWebDrivers//chromedriver.exe");					
		 driver= new ChromeDriver();
		 System.out.println("initialized the chrome driver");
	 }
	 
	   @Given("^I have opened the browser$") 
	   public void openBrowser() { 
	   	   
	       driver.manage().window().maximize();	

	   } 		
	   
		@And("^I am on the home page$")
		public void i_am_on_the_home_page() throws Throwable {
		
		      driver.navigate().to(petClinicURL); 
		}
		
		@When("^I open veterinarians page$")
		public void I_open_veterinarians_page() {
			driver.get(petClinicURL + "/vets.html");
			//assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/vets.html"));
		}

		@Then("^I search for text \"([^\"]*)\"$")
		public void I_search_for_text(String elementName) {
			//assertTrue(driver.findElement(By.xpath("/html/body/div/h2")).getText().equalsIgnoreCase(elementName));
		}
		

		
		

		@Then("^I get owner \"([^\"]*)\" Informations$")
		public void I_get_owner_Informations(String arg1) {
			String ownersName = driver.findElement(By.xpath("/html/body/div/table[1]/tbody/tr[1]/td/b")).getText();
			//System.out.println("Owners name is: " + ownersName);
			//assertTrue(ownersName.contains(arg1));
		}	
	
		@And("I open Find owners and Add owner page")
		public void i_open_find_owners_page() {
		    // Write code here that turns the phrase above into concrete actions
			driver.get(petClinicURL + "/owners/find.html");
			//assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/owners/find.html"));
			driver.findElement(By.xpath("/html/body/div/a")).click();
		   // throw new io.cucumber.java.PendingException();
		}

		@When("I submit details as {string},{string},{string},{string},{string}")
		public void i_enter_details_as(String string1, String string2, String string3, String string4, String string5) {
		    // Write code here that turns the phrase above into concrete actions	
			WebElement fName=driver.findElement(By.id("firstName"));
			fName.sendKeys(string1);
			
			
			WebElement lName=driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
			lName.sendKeys(string2);
			
			WebElement address=driver.findElement(By.xpath("//*[@id=\"address\"]"));
			address.sendKeys(string3);
			WebElement city=driver.findElement(By.xpath("//*[@id=\"city\"]"));
			city.sendKeys(string4);
			WebElement telephone=driver.findElement(By.xpath("//*[@id=\"telephone\"]"));			
			telephone.sendKeys(string5);
			driver.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[6]/button")).click();
			
		    //throw new io.cucumber.java.PendingException();
		}
		
		@Then("The details are {string},{string},{string},{string},{string}")
		public void the_details_are(String string1, String string2, String string3, String string4, String string5) {
		    // Write code here that turns the phrase above into concrete actions
			//assertTrue(driver.findElement(By.xpath("/html/body/div/table[1]/tbody/tr[1]/td/b")).getText().equalsIgnoreCase(string1+" "+string2));
		}
		
		@And("I open find owners")
		public void i_open_find_owners() {
		    // Write code here that turns the phrase above into concrete actions
			driver.get(petClinicURL + "/owners/find.html");
		}
		
		@When("I click find owners")
		public void i_click_find_owners() {
		    // Write code here that turns the phrase above into concrete actions			
			driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/fieldset/div[2]/button")).click();
			
		}
		@Then("I should see the headings {string} on the page")
		public void i_should_see_the_headings_owner_on_the_page(String string) {
		    // Write code here that turns the phrase above into concrete actions
			WebElement ownersList=driver.findElement(By.xpath("/html/body/div/h2"));
			assertTrue(ownersList.getText().equalsIgnoreCase(string));
		}
		
		@When("^I search owner \"([^\"]*)\"$")
		public void I_search_owner(String ownerName) {
			driver.get(petClinicURL + "/owners/find.html");
			//assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/owners/find.html"));
			WebElement search = driver.findElement(By.xpath("//*[@name='lastName']"));
			//System.out.println("Element is :" + search.getText());
			search.sendKeys(ownerName);
			driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/fieldset/div[2]/button")).click();
		}
		
		
		@Then("I get a message {string}")
		public void i_get_a_message(String string) {
		    // Write code here that turns the phrase above into concrete actions
			WebElement ownersList=driver.findElement(By.xpath("//*[@id=\"owner.errors\"]"));
			assertTrue(ownersList.getText().equalsIgnoreCase(string));
			
		}
		
		@Then("I can view PetClinic logo and menu items {string},{string},{string},{string}")
		public void i_can_view_pet_clinic_logo_and_menu_items(String string1, String string2, String string3, String string4) {
		    // Write code here that turns the phrase above into concrete actions
			WebElement logoImage=driver.findElement(By.xpath("/html/body/div/img"));
			assertNotNull(logoImage);
			WebElement home=driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/a"));
			assertTrue(home.getText().trim().equalsIgnoreCase(string1));
			WebElement findOwner=driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/a"));
			assertTrue(findOwner.getText().trim().equalsIgnoreCase(string2));
			WebElement vet=driver.findElement(By.xpath("/html/body/div/div/div/ul/li[3]/a"));
			assertTrue(vet.getText().trim().equalsIgnoreCase(string3));
			WebElement error=driver.findElement(By.xpath("/html/body/div/div/div/ul/li[4]/a"));
			assertTrue(error.getText().trim().equalsIgnoreCase(string4));
		}
		
		
		@After
		public void closeDriver() {
			System.out.println("Closing chrome driver");
			driver.close();
		}

}