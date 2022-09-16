package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class ContactsPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateNewCOntactLookupimg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}

	//	utilization
	public WebElement getCreateNewCOntactLookupimg() {
		return CreateNewCOntactLookupimg;
	}
	
	//business Libraries
	/**
	 * This methods will perform click on create new Organization Look up Image
	 */
	
	public void clickOnCreateNewContactsImg()
	{
		CreateNewCOntactLookupimg.click();
		
	}
	

	

}
