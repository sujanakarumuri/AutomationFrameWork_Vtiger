package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//step1: Create seperate class for every page
	
	//rule2:identify the elements using @FindBy, @FindAll, @FindBys and store it in java class
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3: create a constructor to initialize 
		//Initialization
	public LoginPage(WebDriver driver)
	{
		
	PageFactory.initElements(driver, this);
	
	}
	
	//rule 4: Provide getters to access the element
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//rule 5: Business library
	public void loginToApp(String username, String password )
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	
	
	

	
}
	
	
	

}
