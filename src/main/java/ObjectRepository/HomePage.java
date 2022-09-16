package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class HomePage  extends WebDriverUtilities{
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactlnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslnk;
	
	@FindBy(linkText="Leads")
	private WebElement Leadslnk;
	
	@FindBy(linkText="Products")
	private WebElement Productslnk;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoremouseHover;
	
	@FindBy(linkText="Vendors")
	private WebElement Vendorslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstrationImg;
	
	@FindAll({@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']"), @FindBy(linkText="Sign Out")})
	private WebElement SignOutlnk;
	
	

	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization

	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactlnk() {
		return Contactlnk;
	}

	public WebElement getOpportunitieslnk() {
		return Opportunitieslnk;
	}

	public WebElement getLeadslnk() {
		return Leadslnk;
	}

	public WebElement getProductslnk() {
		return Productslnk;
	}
	
	public WebElement getMoremouseHover() {
		return MoremouseHover;
	}

	public WebElement getVendorslnk() {
		return Vendorslnk;
	}

	public WebElement getAdminstrationImg() {
		return AdminstrationImg;
	}

	public WebElement getSignOutlnk() {
		return SignOutlnk;
	}
	
	//Business Library
/**
 * This method will perform sign out operation	
 * @param driver
 */
 public void signOutofApp(WebDriver driver)
 {
	 mouseHover(driver,AdminstrationImg);
	 SignOutlnk.click();
 }
 
/**
 * This method will perform Click on Organization link
 */
 public void ClickOnOrgLink()
 {
	 OrganizationLnk.click();
 }
 public void ClickOnContactsLink()
 {
	 Contactlnk.click();
	 
 }

 public void MouseHoverOnMore(WebDriver driver)
 {
	 
	 mouseHover(driver,MoremouseHover);
	 Vendorslnk.click();
	 
 }
 public void ClickOnProductLink()
 {
	 Productslnk.click();
	 }
	

}
