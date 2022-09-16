package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtilities;

public class ProductsPage extends WebDriverUtilities{
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductImg;
	
	//initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//utilization	
	public WebElement getCreateProductImg() {
		return CreateProductImg;
	}



	//Business library
	public void CreateNewProductImg()
	{
		CreateProductImg.click();
		
	}

}
