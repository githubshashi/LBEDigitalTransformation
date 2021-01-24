package lbe.digitaltransformation.Dynamics.Test;



import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Myaccount.Test.BaseTest;

public class TTC01_SearchCaseNumber_CRM extends BaseTest
{

	public static final String Sh_ClassR="ClassR";
	
	SoftAssert s_assert= new SoftAssert();
	
	
	@Test (groups = {"Dynamics_CRM"})
	public void Search_for_CaseNumber() 
	{
		TestCasePass="Verified that staff is able to Loggin, Staff is able to view Dasboard page and able to search case number";
		TestCaseFail="Staff is unable to Search case number, 'Some thing went wrong' Please Check the Code";	
		TestCaseSkip="Test Case is Skipped for 'Verify that Staff able to search case number in Dynamics CRM' ";   
		//logger = report.startTest("Opened Dynamics CRM ", "Verify the URL").assignCategory("Functional");
		ut.Switch_Newtab();
		//Switch_Newtab();
		ut.Open_UAT_DYNAMICS_URL();
		
		System.out.println("Opened Dynamics successfully");
		logger.log(LogStatus.INFO, "Opened Dynamics successfully");
		
		
		dsp.Dynamicslogin(11, 0, 1);
		logger.log(LogStatus.INFO, "Successfully logged In and Verified Dashboard page");
		
		dhp.Click_CaseTab();
		dhp.Search_Casenumber(ut.Sh_CommonDetails, 11, 2);
		dhp.ClickonSearch();
		dclp.doubleclickonCasenumbetr();
		logger.log(LogStatus.INFO, "Staff is able to open and view the case details case ");
		
//		driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("kumarps@ealing.gov.uk");
//		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Microland@1234");
//		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
//		Thread.sleep(50000);
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		String result=driver.findElement(By.xpath("//input[@id='idTxtBx_SAOTCC_OTC'] ")).getText();
//		System.out.println(result);
//		WebDriverWait wait=new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//input[@id='idTxtBx_SAOTCC_OTC'] "), result));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//				
//		if(result!=null)
//		{
//			driver.findElement(By.xpath("//input[@id='idSubmit_SAOTCC_Continue']")).click();
//			Thread.sleep(20000);
//		}
//		
//		logger.log(LogStatus.INFO, "Verify that Agent is able to enter Dynamics url on Web browser");
//		logger.log(LogStatus.PASS,"DynamicsCRM successfully Opened ");
//	}
//
//	
//	@AfterMethod (groups = {"Applyforself" , "OnbehalfofAnotherParty"})
//	public void tearDown(ITestResult result) {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			//Utility.captureScrenshot(driver, result.getName());
//			//String Screnshot = Utility.captureScrenshot(driver,Screenshotname);
//			//logger.addScreenCapture(Screnshot);
//			
//		} 
//		//else {
//			//logger.log(LogStatus.ERROR, "Dependant test caese(s) will be skipped if any..! ");
//			//logger.log(LogStatus.FAIL,result.getThrowable());
//			//Utility.captureScrenshot(driver,result.getName()+"_failed");
//			
//		else if(result.getStatus() == ITestResult.FAILURE){
//				 logger.log(LogStatus.FAIL, result.getName()+" Test Case Failed.");
//				 logger.log(LogStatus.FAIL, "Error found at :" +result.getThrowable());
//				// String Screnshot = Utility.captureScrenshot(driver,Screenshotname);
//				// logger.addScreenCapture(Screnshot);
//				 }
//		else if(result.getStatus() == ITestResult.SKIP){
//				 logger.log(LogStatus.SKIP, result.getName()+ "This test Case is Skipped");
//				 }
//				
//				 
//
//		report.endTest(logger);  //endTest(logger) : It ends the current test and prepares to create HTML report
//		report.flush();
//	}
//	
//	@AfterClass (groups = {"Applyforself" , "OnbehalfofAnotherParty"})
//	public void closeBrowser() throws InterruptedException {
//		
//		Thread.sleep(3000);
//		//driver.quit();
//		report.close();
//	}	
	
	
	
	
	}
	
}
