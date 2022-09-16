package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class ProductInfoPage extends WebDriverUtilities {
	
	//declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement ProductHeader;
	
	//intialization
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getProductHeader() {
		return ProductHeader;
	}
	
	//business Libraries
	public String ProductHeaderInfo()
	{
		String ProdHeaderText = ProductHeader.getText();
		return ProdHeaderText;
	}
	
	
	
	
	

}
