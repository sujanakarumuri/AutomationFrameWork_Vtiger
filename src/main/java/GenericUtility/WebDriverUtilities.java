package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	/**
	 * This class contains all the generic methods related to web driver actions
	 * @author sujana
	 */

	public class  WebDriverUtilities {
		

		/**
		 * This method maximize the window
		 * @param driver
		 */
		
		public void maximizewindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * This method will wait for 20 seconds for the entire DOM structure to load
		 * @param driver
		 */
		
		public void waitforElementsToLoadInDOM(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
		
		/**
		 * This method will wait for particular element to be visible
		 * 
		 */
		public void waitForElementToLoad(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * This method will wait for particular element to be Clickable 
		 * @param driver
		 * @param element
		 */
		
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/**
		 * This method will wait for the particular element to perform click operation
		 * if the element is not interactive it will wait for 1 second
		 * @param element
		 * @throws InterruptedException
		 */
		
		public void customWaitAndClckOnElement(WebElement element) throws InterruptedException
		{
			int count=0;
			while(count<10)
			{
				try
				{
					element.click();
					break;
				}
				catch(Exception e)
				{
					Thread.sleep(1000);
	                count++;
				}
			}
		}
		/**
		 * This method will handle drop down by select class using visible text
		 * @param element
		 * @param visibleText
		 */
		public void handleDropDown(WebElement element, String visibleText)
		{
			Select s=new Select(element);
			s.selectByVisibleText(visibleText);
		}
		/**
		 * This method will handle drop down by select class using index
		 * @param element
		 * @param 
		 */
		public void handleDropDown( WebElement element, int Index)
		{
			Select s=new Select(element);
			s.selectByIndex(Index);
		}
		
		/** 
		 * This method will handle drop down by select class using value
		 * @param element
		 * @param 
		 */
		public void handleDropDown(String value, WebElement element)
		{
			Select s=new Select(element);
			s.selectByValue(value);
		}
		/**
		 * This method will handle the mouseHover actions on particular element
		 * @param driver
		 * @param ele
		 */
	     
		public void mouseHover(WebDriver driver, WebElement ele)
		{
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
		}
		/**
		 * This method will handle the mouseHover actions on over the off set
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void mouseHover(WebDriver driver, int x, int y )
		{
			Actions a=new Actions(driver);
			a.moveByOffset(x, y).perform();;
		}
		/**
		 * This method will handle the double click action particular element
		 * @param driver
		 * @param ele
		 * double click overloading method
		 */
		public void doubleClick(WebDriver driver, WebElement ele)
		{
			Actions a=new Actions(driver);
			a.doubleClick(ele).perform();;
		}
		/**
		 *  This method will handle the double click action on over a page
		 * @param driver
		 */
		
		public void doubleClick(WebDriver driver)
		{
			Actions a=new Actions(driver);
			a.doubleClick().perform();;
		}
		/**
		 * This method will handle the right click actions on particular element
		 * @param driver
		 * @param ele
		 */
		public void rightClick(WebDriver driver, WebElement ele)
		{
			Actions a=new Actions(driver);
			a.contextClick(ele).perform();
		}
		/**
		 *  This method will handle the right click actions on over the page
		 * @param driver
		 */
		public void rightClick(WebDriver driver)
		{
			Actions a=new Actions(driver);
			a.contextClick().perform();
		}
		/**
		 * This method will handle the drag and drop actions
		 * @param driver
		 * @param source
		 * @param target
		 */
		public void dragAndDropOn(WebDriver driver, WebElement source, WebElement target)
		{
			Actions a=new Actions(driver);
			a.dragAndDrop(source,target).perform();
		}
		/**
		 * This method will handle the switch the frame(parent to child window) based on index
		 * @param driver
		 */
		public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		/**
		 * This method will handle the switch the frame based on name or id 
		 * @param driver
		 * @param idOrName
		 */
		public void switchToFrame(WebDriver driver, String idOrName)
		{
			driver.switchTo().frame(idOrName);
		}
		/**
		 *  This method will handle the switch the frame based on element
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		/**
		 * This method will handle the switch back to frame(child to parent)
		 * @param driver
		 */
		
		public void switchBackToFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		/**
		 * This method will handle the alert pop up acceptance
		 * @param driver
		 */
		public void acceptAlertPopUp(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		/**
		 * This method will handle the cancel the alert pop up
		 * @param driver
		 */
		public void dismissAlertPopUp(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		/**
		 * This method will get alert pop up text
		 * @param driver
		 * @return
		 */
		public String getText(WebDriver driver)
		{
			String alerttext = driver.switchTo().alert().getText();
			return alerttext;
		}
		/**
		 * This method will handle to switch the windows
		 * @param driver
		 * @param partialTitle
		 */
		public void switchToWindow(WebDriver driver, String partialTitle)
		{
			//step1: get all window handles
			Set<String> windowIds = driver.getWindowHandles();
			
			//step2: Iterate through all the windows
			Iterator<String> it = windowIds.iterator();
			
			//step3: navigate inside the windows
			while(it.hasNext()) //loop until windows exist
			{
				//capture all window ids
				String winid = it.next();
				
				//switch the window and capture the title
				String currentTitle = driver.switchTo().window(winid).getTitle();
				if(currentTitle.contains(partialTitle))
				{
					break;
				}
			}
		}
		/**
		 * This method will takes screenshot and return the destination
		 * @param driver
		 * @param screenShotName
		 * @return 
		 * @throws IOException 
		 */
		public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path=".\\Screenshot\\"+screenShotName+".png";
			File dst=new File(path);
			FileUtils.copyFile(src,dst);
			
			return dst.getAbsolutePath();
		}
		
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", element);
		}

}
