package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class OrganisationInfoPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;

   //initialization
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//business libraries
	
	public String getOrgHeader()
	{
		String OrgHeader = OrgHeaderText.getText();
		return OrgHeader;
		
	}
	
	
	
}
