package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class CreateNewOrganizationPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business Libraries
	
	/**
	 * This method will create new Organization
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgName.sendKeys(Orgname);
		saveBtn.click();
	}
	/**
	 * This method will create new Organization with industry drop down
	 * @param Orgname
	 * @param IndustryType
	 */
	public void createNewOrg(String Orgname,String IndustryType )
	{
		OrgName.sendKeys(Orgname);
		handleDropDown(IndustryType,industryDropDown);
		saveBtn.click();
		
	}
	
	public void createNewOrg(String Orgname, String IndustryType, String TypeDropDown )
	{
		OrgName.sendKeys(Orgname);
		handleDropDown(IndustryType,industryDropDown);
        handleDropDown(TypeDropDown, typeDropDown);
        saveBtn.click();
	}
	

}
