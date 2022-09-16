package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class OrganisationPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateNewOrgLookupImg;
	
	//initialization
	public OrganisationPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);	
	}

	//utilization	
	public WebElement getCreateNewOrgLookupImg() {
		return CreateNewOrgLookupImg;
	}
	
	//business library
	public void clickOnCreateNewOrgImg()
    {
		CreateNewOrgLookupImg.click();
		
	}
	
	

}
