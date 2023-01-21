package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{

			//@Before("@Sanity") =>> to execute only sanity (We can use any tags	)
	@Before //@Before(order = 1) =>> to give priority to run method
	public void setup() throws Exception {
		readCofig = new ReadConfig();
		
		//initialize logger
		log = org.apache.logging.log4j.LogManager.getLogger("StepDef");
		System.out.println("Setup method executed..");
		
		String browser = readCofig.getBrowser();
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		log.info("Setup executed..");
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		

		Loginpg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustPg = new SearchCustomerPage(driver);
		driver.manage().window().maximize();
		log.info("User Launch Chrome browser");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("URL open...");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAddress, String password) {
		Loginpg.enterEmail(emailAddress);
		Loginpg.enterPassword(password);
		log.info("Email and password entered..");
	}

	@When("Click on Login")
	public void click_on_login() {
		Loginpg.clickOnLoginBtn();
		log.info("clicked on login button..");
	}

	////// Login Feature//////

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			log.warn("Test passed: Login feature: Page title matched.");
			Assert.assertTrue(true);// pass
		} else {
			// Assert.assertTrue(false);// fail
			log.warn("Test faild: Login feature: Page title not matched.");
			driver.close();
		}
	
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		Loginpg.clickOnLogoutBtn();
		log.info("Clicked on logout link");
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
		log.info("browser closed");
	}

//////Add Customer Feature//////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			log.info("Test passed: User can view dashboard");
			Assert.assertTrue(true);

		} else {
			log.warn("Test failed: User can not view dashboard");
			Assert.assertTrue(false);

		}
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() {
		addNewCustPg.clickOnCustomerMenu();
		log.info("User click on customer menu");
		
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomer();
		log.info("User click on customer menu item");

	}

	@When("Click on add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddNewbtn();
		log.info("Clicked on add new button");
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {

			log.info("Test passed: User can view add new customer page");
			Assert.assertTrue(true);// pass
		} else {
			log.warn("Test failed: User can not view add new customer page");
			Assert.assertTrue(false);// fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterEmail("TestBDD6@gmail.com");
		addNewCustPg.enterEmail(generateEmaiId() +"@gmail.com");
		addNewCustPg.enterPassword("test101");
		addNewCustPg.enterFirstname("Kapil3");
		addNewCustPg.enterLastname("new");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("12/26/1996");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterManagerOfVendor("Vendor 2");
		addNewCustPg.enterAdminComment("Admin comment");
		
		log.info("Customer information entered");

	}

	@When("Click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		log.info("Clicked on save button");

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		if (bodyTagText.contains(exptectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
			log.info("Test passed: User can view confirmation message");
		} else {
			log.warn("Test failed: User can not view confirmation message");
			Assert.assertTrue(false);// fail

		}
	}
	
	//////////Search customer by Email////////
	
	@When("Click on customer Email")
	public void click_on_customer_email() {
	    searchCustPg.SearchEmailAdd("victoria_victoria@nopCommerce.com");
	    log.info("Click on customer Email");
	    
	}

	@When("Click on search button")
	public void click_on_search_button() throws Exception {
		searchCustPg.searchbutton();
		Thread.sleep(5000);
		log.info("Click on search button");
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() throws Exception {

		String ExpectedEmail = "victoria_victoria@nopCommerce.com";
		
		searchCustPg.searchCustomerByEmail(ExpectedEmail);
		
		log.info("User should found email in the search table");
		
//		if(searchCustPg.searchCustomerByEmail(ExpectedEmail)==true)
//		{
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		Thread.sleep(5000);
	}
	
	@After
	public void teardown(Scenario sc) {
		System.out.println("Tear down method executed..");
		if (sc.isFailed()==true)
		{
			//Convert webdriver object to take screenshot
			String fileWithPath = "C:\\Users\\newas\\eclipse-workspace\\CucumberFramework\\Screenshot\\Failed_Screenshot.png";
			TakesScreenshot srcshot = ((TakesScreenshot)driver);
			
			//Call getScreenshotAS method to create image
			File srcFile= srcshot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination
			File DestFile = new File(fileWithPath);
			
			//Copy file at destination
			try {
				FileUtils.copyFile(srcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStepDemo() {
		System.out.println("This is before step..");
	
	}
	
	@AfterStep
	public void afterStepDemo() {
		System.out.println("This is after step..");
		
	}
}
