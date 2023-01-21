package StepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

import org.apache.logging.log4j.*;

public class BaseClass {

	public WebDriver driver;
	public LoginPage Loginpg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage searchCustPg;
	public static Logger log;
	public ReadConfig readCofig;
	
	public String generateEmaiId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}
}
