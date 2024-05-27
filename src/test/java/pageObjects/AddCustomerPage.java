package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver driver;
	public AddCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//By lnkCustomermenu = By.xpath("//a[@href='#' and @class='nav-link active']");
	By lnkCustomermenu = By.xpath("//i[@class='nav-icon far fa-user']");
	By lnkCustomermenu_item = By.xpath("//a[@href='/Admin/Customer/List']");

	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");
	By txtemail = By.xpath("//input[@type='email']");
	By txtpassword = By.xpath("//input[@type='password']");
	By txtfirstname = By.xpath("//input[@name='FirstName']");
	By txtlastname = By.xpath("//input[@name='LastName']");

	By rdmale_gender = By.xpath("//input[@id='Gender_Male']");
	By rdfemale_gender = By.xpath("//input[@id='Gender_Female']");

	By lstitem_register = By.xpath("//li[contains(text(), 'Registered')]");
	By lstitem_Guests = By.xpath("//li[contains(text(), 'Guests')]");
	By lstitme_Vendors = By.xpath("//li[contains(text(), 'Vendors')]");

	By btnSave = By.xpath("//button[@name='save']");

	// Action method
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void customerdropdown() {

		driver.findElement(lnkCustomermenu).click();

	}
	public void customers() {

		driver.findElement(lnkCustomermenu_item).click();

	}
	public void addnewcustomer() {

		driver.findElement(btnAddnew).click();

	}
	public void setEmail(String email) {
		driver.findElement(txtemail).sendKeys(email);

	}	
	public void setPassword(String password) {
		driver.findElement(txtpassword ).sendKeys(password);
	}
	
	public void setFirstname(String firstname) {
		driver.findElement(txtfirstname).sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		driver.findElement(txtlastname).sendKeys(lastname);
	}
	
	public void selectGender(String gender) {
		if(gender.equals("Male")){
			driver.findElement(rdmale_gender).click();
				}
		else if(gender.equals("Female")) {
			driver.findElement(rdfemale_gender).click();
		}
		else {
			driver.findElement(rdmale_gender).click();
		}
	}

	public void savebutton() {
		driver.findElement(btnSave).click();
		}
	
	
	

}
