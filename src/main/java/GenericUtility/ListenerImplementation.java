package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import GenericUtility.BaseClass;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtilities;


	
	/**
	 * This class acts like a implementation class to override all the methods
	 * present in interface interface
	 * @author sujana
	 *
	 */
	public class ListenerImplementation implements ITestListener{
		
		ExtentReports report;
		ExtentTest test;

		public void onTestStart(ITestResult result) {
			String methodname = result.getMethod().getMethodName();
			test=report.createTest(methodname);
			//Reporter.log(methodname+"=== test script execution started===", true);
		
		}

		public void onTestSuccess(ITestResult result) {
			String methodname = result.getMethod().getMethodName();
			test.log(Status.PASS,methodname+"-------passed");
			//Reporter.log(methodname+"=== is passed===", true);
			
		}

		public void onTestFailure(ITestResult result) {
			WebDriverUtilities wUtil=new WebDriverUtilities();
			JavaUtility jUtil=new JavaUtility();
			
			//This will capture the exception occured
			//String msg = result.getThrowable().toString();
			
			//This will capture the test method name
			String methodname = result.getMethod().getMethodName();
			
			//this will append the method name with the date of for screenshot
			String screenShotName = methodname+jUtil.getSystemdateFormat();
			 
			test.log(Status.FAIL,methodname+"----Failed");
			test.log(Status.FAIL,result.getThrowable());
			
			try {
				String path = wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
				test.addScreenCaptureFromPath(path);//navigate to screen shot path and attach in to the report
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Reporter.log(methodname+"is failed becuase =="+msg,true);
		
		}

		public void onTestSkipped(ITestResult result) {
			//String msg = result.getThrowable().toString();
			String methodname = result.getMethod().getMethodName();
			test.log(Status.SKIP,methodname+"------skipped");
			test.log(Status.SKIP,result.getThrowable());
			//Reporter.log(methodname+"is skipped becuase =="+msg,true);
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			//start of suite execution
			//configure the extent report
			ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemdateFormat()+".html");
			htmlreport.config().setDocumentTitle("WASM-vtiger Execution report");
			htmlreport.config().setTheme(Theme.DARK);
			htmlreport.config().setReportName("Vtiger report");
			
			report=new ExtentReports();
			report.attachReporter(htmlreport);
			report.setSystemInfo("Base browser","Chrome");
			report.setSystemInfo("Base_platform","Windows");
			report.setSystemInfo("Base url","http://localhost:8888");
			report.setSystemInfo("Reporter name","Sujana");
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			//end of suite execution
			report.flush(); //consolidate all the test script execution and dump the status in to the report
		
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
		
		}
		


}
