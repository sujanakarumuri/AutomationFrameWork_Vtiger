package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class CreatingNewProductPage extends WebDriverUtilities{
	
	//declaration
	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement VendorNameLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement SearchTextEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	//initialization
	public CreatingNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getVendorNameLookUpImg() {
		return VendorNameLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return SearchTextEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	//Business libraaries
	/**
	 * This method will handles to create a new product
	 * @param prodname
	 */
	
	public void ProdNameEdt(String prodname)
	{
		ProductNameEdt.sendKeys(prodname);
		SaveBtn.click();
		
	}
	
	public void ProdNameEdt(String prodname, String vendorname, WebDriver driver )
	{
		ProductNameEdt.sendKeys(prodname);
		VendorNameLookUpImg.click();
		switchToWindow(driver,"Vendors");
		SearchTextEdt.sendKeys(vendorname);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorname+"']")).click();
		switchToWindow(driver,"Products");
		SaveBtn.click();
		
		
	}
	

	
	
	

}
