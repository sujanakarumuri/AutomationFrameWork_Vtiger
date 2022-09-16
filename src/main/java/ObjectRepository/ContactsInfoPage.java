package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class ContactsInfoPage extends WebDriverUtilities{
	
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ConactsHeaderInfo;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getConactsHeaderInfo() {
    return ConactsHeaderInfo;
	}
	
	//business Libraries
	public String getContactInfo()
	{
		String ContactHeader = ConactsHeaderInfo.getText();
		return ContactHeader;
		
	}
}
	
	

