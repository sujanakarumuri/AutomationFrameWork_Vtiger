package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class CreateNewVendor extends WebDriverUtilities{
	
	@FindBy(name="vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewVendor(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business library
	public void CreateNewVendorEdt(String vendorname)
	{
		VendorNameEdt.sendKeys(vendorname);
		SaveBtn.click();
	}
	
	
	

}
