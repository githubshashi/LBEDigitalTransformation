package lbe.digitaltransformation.Myaccount.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Dynamics.Pages.DynamicsCaseListPage;
import lbe.digitaltransformation.Dynamics.Pages.DynamicsHomePage;
import lbe.digitaltransformation.Dynamics.Pages.DynamicsSignIn;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassB;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassD;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassF;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassG;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassI;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassK;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassL;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassR;
import lbe.digitaltransformation.Myaccount.pages.MyAccountClassV;
import lbe.digitaltransformation.Myaccount.pages.MyAccountCouncilTax;
import lbe.digitaltransformation.Myaccount.pages.MyAccountHomepage;
import lbe.digitaltransformation.Myaccount.pages.MyAccountSignIn;
import lbe.digitaltransformation.Utility.BrowserFactory;
import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.Utility;

public class BaseTest 
{
	
	public static ExtentReports report;
	public static ExtentTest logger;

	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	public WebDriver driver;
	BrowserFactory bf=new BrowserFactory(driver);
	public  MyAccountHomepage hp;
	public static Utility ut;
	public static MyAccountSignIn sp;
	public static MyAccountCouncilTax ct;
	public static MyAccountClassD cd;
	public static MyAccountClassV cv;
	public static MyAccountClassG cg;
	public static MyAccountClassI ci;
	public static MyAccountClassL cl;
	public static MyAccountClassF cf;
	public static MyAccountClassB cb;
	public static MyAccountClassK ck;
	public static MyAccountClassR cr;
	
	//----------------------------------------------------------------------------------
	public static DynamicsSignIn dsp;
	public static DynamicsHomePage dhp;
	public static DynamicsCaseListPage dclp;
	
	protected String TestCasePass;
	protected String TestCaseFail;
	protected String TestCaseSkip;
	protected String TestName;
	
	
	@BeforeSuite (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void BrowserLaunch_ReportInitiate()
	{
		driver= bf.startBrowser();
		hp= new MyAccountHomepage(driver);
		sp= new MyAccountSignIn(driver);
		ct=new MyAccountCouncilTax(driver);
		cd=new MyAccountClassD(driver);
		ut=new Utility(driver);
		cv=new MyAccountClassV(driver);
		cg=new MyAccountClassG(driver);
		ci=new MyAccountClassI(driver);
		cl=new MyAccountClassL(driver);
		cf=new MyAccountClassF(driver);
		cb=new MyAccountClassB(driver);
		ck=new MyAccountClassK(driver);
		cr=new MyAccountClassR(driver);
		
		//--------------------------------
		
		dsp=new DynamicsSignIn(driver);
		dhp=new DynamicsHomePage(driver);
		dclp=new DynamicsCaseListPage(driver);


		String dateName = new SimpleDateFormat("dd.MMM.yyyy.HH:mm:ss").format(new Date());
		
		report = new ExtentReports("./TestReport/ValidationCheck_SubmitCase_"+dateName+".html",true);	
		report.addSystemInfo("Tester Name", "Shashi/Sourav");
		report.addSystemInfo("Project Name", "LBE_DigitalTransfermation");
		report.addSystemInfo("Envirnoment", "UAT");
		report.loadConfig(TC01_ClassD_ValidationCheck_SubmitCase.class,"resources", "extent-config.xml");
		//report.loadConfig(new File(System.getProperty("user.dir")+"\\lbe.digitaltransformation.Myaccount.Test.resources\\extent-config.xml"));
	}
	
	@AfterSuite (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void BrowserClosed_ReportGenerated()
	{
		
		//driver.close();
		//driver.quit();
		////report.flush();
		report.close();	
	}
	
	@BeforeTest (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void CouncilWebsiteOpened()
	{		
	   ut.Open_UAT_PORTAL_URL();
	   hp.ClickonSignIn();
	   sp.SignInPageTitle();
	   sp.login(1,0);
  
	   TestName="Services";
	}
	
	@BeforeClass (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void ToStartReport()
	{
				
		if(TestName==null)
		{		//TestName = (this.getClass().getName()).substring(41, 68); 
			TestName = (this.getClass().getName()).substring(41); 
			logger = report.startTest(TestName).assignCategory("Functional Testing, Field Level (Invalid Check) Testing - Result Report");
		}  
		else 
		{	TestName = (this.getClass().getName()).substring(41);	
			logger = report.startTest(TestName).assignCategory("Functional Testing, Field Level (Invalid Check) Testing - Result Report");
		}
		hp.HomeIcon();
	}
	
	@AfterClass (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void ToEndReport()
	{
		
		report.endTest(logger); //It ends the current test and prepares to create HTML report
		report.flush();
		//driver.navigate().refresh();	
	}
	
	
	@AfterMethod (groups = {"Apply_for_self","Onbehalf_of_SomeOneElse"})
	public void tearDown(ITestResult result) 
	{
//		String FailureScreenshot="TestCase_Failed"; 
//		String SkippedScreenshot="TestCase_Skipped"; 
	
		if (result.getStatus() == ITestResult.SUCCESS)
		{	
			logger.log(LogStatus.PASS, TestCasePass);
		} 		
		else if(result.getStatus() == ITestResult.FAILURE) 
		{
				 logger.log(LogStatus.FAIL, result.getName()+" -Test Case Failed.");
				 logger.log(LogStatus.FAIL, "Error found at :" +result.getThrowable());
				
		}
		else if(result.getStatus() == ITestResult.SKIP) 
		{
				 logger.log(LogStatus.SKIP, result.getName()+ "This test Case is Skipped");
			
		 }
		
	}
	
	

	


}
