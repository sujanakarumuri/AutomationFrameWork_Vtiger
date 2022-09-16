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
	import io.github.bonigarcia.wdm.WebDriverManager;
	@Listeners(GenericUtility.ListenerImplementation.class)
	public class OrgWithContactTest  extends BaseClass{
		
		//@Test
		@Test(groups="SmokeSuite")
		
		public void CreateContactWithOrg() throws IOException
		{
			
			//read data from excel sheet
			String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2);
			
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
			
			
	   
				   
			   	   
			  
	}
	}
