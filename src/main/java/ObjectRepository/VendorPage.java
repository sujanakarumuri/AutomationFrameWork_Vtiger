package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class VendorPage extends WebDriverUtilities{
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement CreateNewVendorLookUpImg;
	
	
	//initialization
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//utilization
		public WebElement getCreateNewVendorLookUpImg() 
		{
		return CreateNewVendorLookUpImg;
	   }
		
		//Business Libraries
		public void ClickOnNewVendorLinkImg()
		{
			CreateNewVendorLookUpImg.click();
			
		}
	
	

}
