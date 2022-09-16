package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class CreateNewContactsPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgLookupImg;
	
	@FindBy(name="search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getLastName() {
		return ContactNameEdt;
	}

	public WebElement getOrgName() {
		return orgLookupImg;
	}
	
	

	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}

	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}



	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	/**
	 * This method create a new contact
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		ContactNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	/**
	 * THis methods create a contact with last name and organization name
	 * @param lastname
	 * @param orgname
	 * @param driver
	 */
	
	public void createNewContact(String lastname, String orgname, WebDriver driver )
	{
		ContactNameEdt.sendKeys(lastname);
		orgLookupImg.click();
		switchToWindow(driver,"Accounts");
		searchBoxEdt.sendKeys(orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click(); //dynamic path
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
	}
	
	/**
	 *  THis methods create a contact with last name and lead source drop down
	 * @param lastname
	 * @param leadSourceType
	 */
	
	public void createNewContact(String lastname, String leadSourceType )
	{
		ContactNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceType, leadSourceDropDown);
		saveBtn.click();
		
	}
	
	

}
