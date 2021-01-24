package lbe.digitaltransformation.Myaccount.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.relevantcodes.extentreports.ExtentTest;


import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class MyAccountClassD  {

	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	
	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	
	 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String FirtName_Alphanumaric_ExpectRes="First Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String LastName_Aplhanumaric_ExpectRes="Last Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 
	 
	 
	 
	 public MyAccountClassD(WebDriver ldriver) 
	{		this.driver = ldriver;    	}
	
	
	public String Page_heading()
	{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
		return Heading1;	
	}
	
//	public void Verify_ClassD_Service_titlepage() {
//		try {Assert.assertEquals(driver.getTitle(), conf.verifytitleclassD());
//		} catch (Exception e) {
//		e.printStackTrace();	}	}
	

	

	public void CTAccountnumber()
	{ try { driver.findElement(By.xpath(conf.Acc_num())).sendKeys("4234566"); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	//---------------------------------------------Account Details Page---------------------------------
	
	public void MandatoryFieldCheck()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.findElement(By.xpath(conf.nextbtn2())).click();                             //  Clicks NEXT button before Enter data to check mandatory message displayed or not
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.mandatorycheck()), "The form could not be submitted for the following reasons:"));
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		String Actual_result = driver.findElement(By.xpath(conf.mandatorycheck())).getText();
		Assert.assertEquals(Actual_result , Mandatory_ExpectedResult);
	}
	
	
	
	public void ENter_DetainedFirstname(String sheetname,int a,int b)
	{ try 
	{ 	driver.findElement(By.xpath(conf.firstnametxt())).sendKeys("9876fdhgdhdhd");
		driver.findElement(By.xpath(conf.nextbtn2())).click();                               //  Clicks NEXT button before Enter data to check mandatory message displayed or not
		String Actual_result1 = driver.findElement(By.xpath(conf.Firstname_Alphanumaric_check())).getText();
		Assert.assertEquals(Actual_result1 , FirtName_Alphanumaric_ExpectRes, " --(Detained FirstName field is value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
		driver.findElement(By.xpath(conf.firstnametxt())).clear();
		driver.findElement(By.xpath(conf.firstnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	public void Enter_Detainedlastname(String sheetname,int a, int b)
	{ try 
	{   driver.findElement(By.xpath(conf.lastnametxt())).sendKeys("98fdhgdhdhd");
		driver.findElement(By.xpath(conf.nextbtn2())).click(); 
		String Actual_result2 = driver.findElement(By.xpath(conf.Lastname_Alphanumaric_check())).getText();
		Assert.assertEquals(Actual_result2 , LastName_Aplhanumaric_ExpectRes, " --(Detained LastName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Lastname. 
		driver.findElement(By.xpath(conf.lastnametxt())).clear();
		driver.findElement(By.xpath(conf.lastnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void onbehalfFirstname(String sheetname)
	{ try { driver.findElement(By.xpath(conf.onbehalffirstnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,6)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void onbehalflastname(String sheetname)
	{ try { driver.findElement(By.xpath(conf.onbehalflastnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,7)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
//	public void onbehalfPostcodeAddress()
//	{ try { driver.findElement(By.xpath(conf.enteronbehalfpostcode())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,8)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
	public void onbehalfClick_Go()
	{ try { driver.findElement(By.xpath(conf.clickonbhalfGo())).click(); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void onbehalfselectAddress()
	{ try {  Select address=new Select(driver.findElement(By.xpath(conf.selectonbehalfaddress())));
	address.selectByIndex(6);  }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void telphonenumber()
	{ try { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys("9876fdhgdhdhd");		
			driver.findElement(By.xpath(conf.nextbtn2())).click(); 
			String Actual_result = driver.findElement(By.xpath(conf.Mobilenumber_Invalid_check())).getText();
			Assert.assertEquals(Actual_result , ContactNumber_Invalid_ExpectRes, " --(Contact Number field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Contact Number.  
			js.executeScript("window.scrollBy(0, 1000)"); 
			driver.findElement(By.xpath(conf.telphonenumbertxt())).clear();
			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,1,3)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
//	public void emailaddress()
//	{ try { driver.findElement(By.xpath(conf.emailaddresstxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,10)); }
//	catch(Exception e)
//	{ e.printStackTrace(); }	}
	
	public void Accountdetailspage_nextbtn()
	{ try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conf.nextbtn2())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void Accountdetailspage_SaveExit()
	{ try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conf.SaveExit())).click();
	}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	
	//------------------------------------Application Details Page---------------------------------------------------------------
	
	public void Datedetentioncommenced(String sheetname)
	{ try { driver.findElement(By.xpath(conf.DatedetentioCommenced())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,12)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void Name_Address(String sheetname)
	{ try { driver.findElement(By.xpath(conf.NameofPrison_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,13)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void PrisonerNumber(String sheetname)
	{ try { driver.findElement(By.xpath(conf.PrisonerNumber_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,14)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void PersonDOB(String sheetname)
	{ try {driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.xpath(conf.DOB_date())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,15));
	}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void RemandedinCustody(String sheetname)
	{ try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select custody=new Select(driver.findElement(By.xpath(conf.Custody_dpd())));
	custody.selectByIndex(1); 
	}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void ExpectedReleasedate(String sheetname)
	{ try {driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.xpath(conf.Releasedate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,16));
	}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void NonPayment()
	{ try { Select payment=new Select(driver.findElement(By.xpath(conf.NonPayment_dpd())));
	payment.selectByIndex(1);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	
	
	
	
	
	//--------------------------------Citizen Documents Page----------------------------------
	

	

	
	
	
	//------------------------------------------------Review Request Details------------------
	
//	public void ClickCheckBox()
//	{try { driver.findElement(By.xpath(conf.CheckBox())).click();
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
//	catch(Exception e)
//	{ e.printStackTrace(); } } 
	
	public void ClickReview_btn()
	{try { driver.findElement(By.xpath(conf.Review_btn())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); } }
	
	public void ClickEdit_btn()
	{try { driver.findElement(By.xpath(conf.Edit_btn())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); } }
	
	public void ClickSaveClose_btn()
	{try { driver.findElement(By.xpath(conf.SaveClose_btn())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); } }
	
//	public void ClickSubmit_btn()
//	{try { 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(conf.Submit_btn())).click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); }
//	catch(Exception e)
//		{ e.printStackTrace(); } }

	
	
	

	
	
	
}
