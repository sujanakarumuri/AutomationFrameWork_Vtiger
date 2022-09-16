package GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

	/**
	 * This class contains basic configuration annotation for common functionalities
	 * for database connection, launch the browser
	 * @throws SQLException
	 */
	public class BaseClass {

		public DataBaseFileUtility dUtil=new DataBaseFileUtility();
		public ExcelFileUtility eUtil=new ExcelFileUtility();
		public PropertyFileUtility pUtil=new  PropertyFileUtility();
		public JavaUtility jUtil=new JavaUtility();
		public WebDriverUtilities wUtil=new WebDriverUtilities();
		
		 public WebDriver driver=null;
		 public static WebDriver sdriver=null;
		@BeforeSuite
		 //@BeforeSuite(groups={"SmokeSuite", "RegressionSuite"})
		public void bsConfig() throws SQLException 
		{
			dUtil.connectToDB();
			Reporter.log("======DataBase Connected successfully====", true);
		}
		@BeforeClass
		//@BeforeClass(groups={"SmokeSuite", "RegressionSuite"})
		public void bcConfig() throws IOException
		{
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
				if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser");
				}
			
			Reporter.log("Browser "+BROWSER+" launched successfully", true);
		
			sdriver=driver;
			wUtil.maximizewindow(driver);
			wUtil.waitforElementsToLoadInDOM(driver);
			driver.get(URL);
		}
		@BeforeMethod
		//@BeforeMethod(groups={"SmokeSuite", "RegressionSuite"})
		public void bmConfig() throws IOException
		{
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("======Launch the application successfully=====", true);
			
		}
		@AfterMethod
		//@AfterMethod(groups={"SmokeSuite", "RegressionSuite"})
		public void amConf()
		{
			HomePage hp=new HomePage(driver);
			hp.signOutofApp(driver);
			Reporter.log("===========signout successfully=====");
		}
		@AfterClass
		//@AfterClass(groups={"SmokeSuite", "RegressionSuite"})
		public void acConfig()
		{
			driver.close();
			Reporter.log("===========Browser closed successfully=====");
		}
		@AfterSuite
		//@AfterSuite(groups={"SmokeSuite", "RegressionSuite"})
		public void asConfig() throws SQLException
		{
			dUtil.closeDB();
			Reporter.log("===========Ddatabase closed successfully=====");
			
			
		}
		
		
		
	}

	

		


