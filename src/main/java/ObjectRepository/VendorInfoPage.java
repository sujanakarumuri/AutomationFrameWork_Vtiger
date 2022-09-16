package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class VendorInfoPage extends WebDriverUtilities{
	
	//declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement VendorHeaderText;
	
	//initialization
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getVendorHeader() {
		return VendorHeaderText;
	}
	
	//Business library
	public String getVendorInfo()
	{
		String VendorHeader = VendorHeaderText.getText();
		return VendorHeader;
	}
	
	

}
