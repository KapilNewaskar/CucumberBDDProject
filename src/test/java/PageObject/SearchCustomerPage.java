package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement txtsearchemail;

	@FindBy(id = "search-customers")
	WebElement searchbtn;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr[1]//td")
	List<WebElement> tableColumns;

	public void SearchEmailAdd(String email) {
		txtsearchemail.sendKeys(email);
	}

	public void searchbutton() {
		searchbtn.click();
	}

	
	public void searchCustomerByEmail(String email) {
		
		String ExpectedEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[1]//td[2]")).getText();
		if(ExpectedEmail.equals(email)) {
			System.out.println("Test pass");
		}
	}
	
	
//	public boolean searchCustomerByEmail(String email) {
//		boolean found = false;
//
//		int ttlRows = tableRows.size();// total no of rows
//		// int ttlColumns = tableColumns.size();//total no of columns
//
//		for (int i = 1; i < ttlRows; i++) {
//			System.out.println("Searching row:" +i );
//			WebElement WebelementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
//			
//			String actualEmail = WebelementEmail.getText();
//			System.out.println(actualEmail);
//			
//			if (actualEmail.equals(email)) {
//				found = true;
//			}
//		}
//		return found;
//	}

}
