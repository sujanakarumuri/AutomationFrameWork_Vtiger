package orgWithContact;
import java.io.IOException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import GenericUtility.BaseClass;
	import GenericUtility.ExcelFileUtility;
	import GenericUtility.JavaUtility;
	import GenericUtility.PropertyFileUtility;
	import GenericUtility.WebDriverUtilities;
	import ObjectRepository.ContactsInfoPage;
	import ObjectRepository.ContactsPage;
	import ObjectRepository.CreateNewContactsPage;
	import ObjectRepository.CreateNewOrganizationPage;
	import ObjectRepository.HomePage;
	import ObjectRepository.OrganisationInfoPage;
	import ObjectRepository.OrganisationPage;
import ObjectRepository.CreateNewVendor;
import ObjectRepository.CreatingNewProductPage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductsPage;
import ObjectRepository.VendorInfoPage;
import ObjectRepository.VendorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
	@Listeners(GenericUtility.ListenerImplementation.class)
	public class EndToEndScenarioTest  extends BaseClass{
		
		//@Test
		@Test(groups="SmokeSuite")
		
		public void CreateContactWithOrg() throws IOException
		{
			
			//read data from excel sheet
			String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2);
			String VENDORNAME = eUtil.readDataFromExcelSheet("Products", 1, 3)+jUtil.getRandomNumber();
			String PRODUCTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2)+jUtil.getRandomNumber();
			
			/* Navigate to Organization*/
			HomePage hp=new HomePage(driver);
			hp.ClickOnOrgLink();
			Reporter.log("Organisation link clicked",true);
			
			
			/*click on create organisation */
			OrganisationPage op=new OrganisationPage(driver);
			op.clickOnCreateNewOrgImg();
			Reporter.log("new Organisation img link clicked",true);
			
			
			CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
			cnp.createNewOrg(ORGNAME);
			Reporter.log("Create Organisation with org name",true);
			
			
			//validate
			OrganisationInfoPage OrgInf=new OrganisationInfoPage(driver);
			String ORGHEADER = OrgInf.getOrgHeader();
			Assert.assertTrue(ORGHEADER.contains(ORGNAME));
			Reporter.log("===ORGANISATION CREATED===", true);
			
			
			
			//click on contacts
			hp.ClickOnContactsLink();
			Reporter.log("Contact link clicked",true);
			
			
			//navigate to contacts page
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateNewContactsImg();
			Reporter.log("new Contacts img link clicked",true);
			
			//navigate to create new contact page
			CreateNewContactsPage cnc=new CreateNewContactsPage(driver); 
			cnc.createNewContact(LASTNAME, ORGNAME, driver);
			Reporter.log("Contact created with mandatory fields ",true);
			
			//validation
			ContactsInfoPage cip=new ContactsInfoPage(driver);
			String CONTACTHEADER = cip.getContactInfo();
			Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
			Reporter.log("========Contact created======", true);
			
			
			  
				
				//String VENDORNAME = eUtil.readDataFromExcelSheet("Products", 1, 3)+jUtil.getRandomNumber();
				//String PRODUCTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2)+jUtil.getRandomNumber();
				
				
				
			
				//navigate to vendors
				 hp=new HomePage(driver);
				hp.MouseHoverOnMore(driver);
				
				//click on create new vendor img
				VendorPage vp=new VendorPage(driver);
				vp.ClickOnNewVendorLinkImg();
				
				//enter all the mandatory fields
				CreateNewVendor cnv=new CreateNewVendor(driver);
				cnv.CreateNewVendorEdt(VENDORNAME);
				
				//validate
				VendorInfoPage vip=new VendorInfoPage(driver);
				String VENDORHEADER = vip.getVendorHeader().getText();
				Assert.assertTrue(VENDORHEADER.contains(VENDORNAME));
				Reporter.log("===Vendor created=====",true);
				
				//navigate to products
				hp.ClickOnProductLink();
				
				//navigate to products page
				ProductsPage pp=new ProductsPage(driver);
				pp.CreateNewProductImg();
				
				//navigate to creating new product page
				CreatingNewProductPage cnp1=new CreatingNewProductPage(driver);
				cnp1.ProdNameEdt(PRODUCTNAME, VENDORNAME, driver);
				
				//validate
				ProductInfoPage pip=new ProductInfoPage(driver);
				String PRODUCTHEADER = pip.ProductHeaderInfo().toString();
				
			
				Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
				Reporter.log("------product is created-----",true);
				
				
				
			}
			
			
			
			
			

			
			   
				   
			   	   
			  
	}
	