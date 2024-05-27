package stepDefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		logger = Logger.getLogger("nopCommerece_Cucumber");
		PropertyConfigurator
				.configure("C:\\Users\\Rohit\\eclipse-workspace\\nopCommerece_Cucumber\\test-output\\log4j.properties");
		// System.setProperty("WebDriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe"
		// );
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rohit\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();

		logger.info("****Launching browser****");

		// what is the issue--> lp = new LoginPage(driver);
		lp = new LoginPage(driver);

	}

	@When("User open Url {string}")
	public void user_open_Url(String string) {
		logger.info("****Opening URL****");
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
	}

	@When("Users Enter email as {string} and password as {string}")
	public void users_Enter_email_as_and_password_as(String email, String password) {
		logger.info("****Providing login details****");
		lp.setUserName(email);
		lp.setUserPassword(password);
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		logger.info("****Started Login****");
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("****Closing browser****");
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("****Portal Logout****");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@When("close browser")
	public void close_browser() {
		logger.info("****Quitting browser****");
		driver.quit();
	}

// Customer feature step definitions

	@Then("user can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(2000);

	}

	@When("user click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("****Opening Customer Menu****");
		addCust.customerdropdown();
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("****Opening Customer Sub Menu****");
		addCust.customers();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
		logger.info("****Clicking on new button****");
		addCust.addnewcustomer();
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		logger.info("****Add new customer page ****");
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {

		String email = randomstring() + "@gmail.com";
		addCust.setEmail(email);

		addCust.setPassword("test123");
		addCust.setFirstname("Rohit");
		addCust.setLastname("Sandawa");
		addCust.selectGender("Male");

	}

	@When("click on save button")
	public void click_on_save_button() {
		logger.info("****Save button for saving the new user****");
		addCust.savebutton();
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}

	// Steps for searching a customer

	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		searchCust = new SearchCustomerPage(driver);
		logger.info("****Entering Customer Email****");
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		// searchCust.setFirstName("Victoria");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("****Clicking on search button****");
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		logger.info("****Checking of email on search table****");
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

}