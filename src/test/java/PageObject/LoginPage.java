package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver; // ldriver = local driver
	
	public LoginPage(WebDriver rDriver ){
		ldriver=rDriver; // rDriver = remote driver
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginbutton;
	
	@FindBy(linkText = "Logout")
	WebElement logoutbutton;
	
	public void enterEmail(String emailAddress) {
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String passwrd) {
		password.clear();
		password.sendKeys(passwrd);
	}
	
	public void clickOnLoginBtn() {
		loginbutton.click();
	}
	
	public void clickOnLogoutBtn() {
		logoutbutton.click();
	}
	
}
