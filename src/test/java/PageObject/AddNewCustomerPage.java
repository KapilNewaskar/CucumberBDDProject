package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	WebDriver ldriver; // ldriver = local driver

	public AddNewCustomerPage(WebDriver rDriver) {
		ldriver = rDriver; // rDriver = remote driver
		PageFactory.initElements(rDriver, this);
	}

	// Webelements for customer page

	@FindBy(xpath  = "(//a[@class='nav-link'])[21]")
	WebElement customers_menu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customers;

	@FindBy(linkText = "Add new")
	WebElement addnewbtn;

	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Password")
	WebElement Password;

	@FindBy(id = "FirstName")
	WebElement firstname;

	@FindBy(id = "LastName")
	WebElement lastname;

	@FindBy(id = "Gender_Male")
	WebElement MaleGender;

	@FindBy(id = "Gender_Female")
	WebElement FeMaleGender;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;

	@FindBy(xpath = "(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]")
	WebElement txtNewsletter;
	
	@FindBy(xpath = "(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]")
	WebElement TestStore;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;

	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminComment;

	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;

	// Actions Methods for web elements

	public String getPageTitle()
	{
		return ldriver.getTitle();
	} 

	public void clickOnCustomerMenu() {
		customers_menu.click();
	}

	public void clickOnCustomer() {
		customers.click();
	}

	public void clickOnAddNewbtn() {
		addnewbtn.click();
	}

	public void enterEmail(String email) {
		Email.sendKeys(email);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void enterFirstname(String Firstname) {
		firstname.sendKeys(Firstname);
	}

	public void enterLastname(String Lastname) {
		lastname.sendKeys(Lastname);
	}

	public void enterGender(String gender) {
		if (gender.equals("Male")) {
			MaleGender.click();
		} else if (gender.equals("Female")) {
			FeMaleGender.click();
		} else// default set Male gender
		{
			MaleGender.click();
		}

	}

	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void enterManagerOfVendor(String value1) {
		Select drp = new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value1);
	}

	public void enterNewsletter() {
		txtNewsletter.click();
		TestStore.click();
	}

	public void enterCustomerRoles(String value3) {
		txtCustomerRoles.sendKeys(value3);
	}

	public void enterCompanyName(String coName) {
		txtCompanyName.sendKeys(coName);
	}

	public void enterAdminComment(String comment) {
		txtAdminComment.sendKeys(comment);
	}

	public void clickOnSave() {
		btnSave.click();
	}
}
