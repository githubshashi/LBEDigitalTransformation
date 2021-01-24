package lbe.digitaltransformation.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;

import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.ExcelReadWrite;

public class Utility {
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	ConfigReaderDynamics DynCRM = new ConfigReaderDynamics();
	
	 public WebDriver driver;
	 ExtentReports report;
	 WebDriverWait wait;
	
	public Utility(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	String Delegation_FirtName_Alphanumaric_ExpRes="First Name - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	String Delegation_LastName_Alphanumaric_ExpRes="Last Name - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String Mandatory_Feilds_Expected="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter."; 
	
	
	
	public static final String UploadFilepath=System.getProperty("user.dir");
	public static final String Uploaddocument="\\TestData\\Document.jpg";
	public static final String excelfilepath=".\\TestData\\MyAccountTestData.xlsx";
	public static final String Sh_CommonDetails="CommonDetails";

	

	
	
	//--------------To open the Council UAT Portal Url--------------
	
		public void Open_UAT_PORTAL_URL() 
		{		
			try { 	driver.get(conf.getURL());  } 
			catch (Exception e) {  e.printStackTrace();  }
		}
	
	//-------------------------Verify the SubService Title page-----------------------
		
		public void Verify_SubService_titlepage() {
			try {Assert.assertEquals(driver.getTitle(), conf.SubServicetitle_labelName());
			} catch (Exception e) {
			e.printStackTrace();	}	}
	
	//--------------- To Capture Screen shot when testcase is pass/failed----------------------
	
	public  String captureScrenshot(String screenshotName) {

		try {
			System.out.println(driver);
			System.out.println(screenshotName);
			String dateName = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date());
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dest = ".\\Screenshots\\" + screenshotName + dateName+ ".png";
			
			FileUtils.copyFile(src, new File(dest));      // Copy the screenshot to desired location using copyFile method
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//System.out.println(dest);
			return dest;		
		} 
		catch (Exception e)
		{				return e.getMessage();      	}
	}
	
	
	public void Switch_Newtab()
	{
		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
		
	}
	
	//--------------------Common feild occurs in all pages---------------------------------
	
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
			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Sh_CommonDetails,1,3)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void CTAccountnumber(String filepath,int a,int b)
	{ try { driver.findElement(By.xpath(conf.Acc_num())).sendKeys(ExcelReadWrite.getCellData(filepath,Sh_CommonDetails,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void MandatoryFieldCheck()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.findElement(By.xpath(conf.nextbtn2())).click();                             //  Clicks NEXT button before Enter data to check mandatory message displayed or not
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.mandatorycheck()), "The form could not be submitted for the following reasons:"));
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		String Actual_result = driver.findElement(By.xpath(conf.mandatorycheck())).getText();
		Assert.assertEquals(Actual_result , Mandatory_Feilds_Expected);
	}
	
	
	
	
	//--------------------Select Apply for self OR On behalf of another party drop down--------------------------------------
	
	public void select_self_onbehalf(int i)
	{ 		try { 		Select selfbehalf=new Select(driver.findElement(By.xpath(conf.ApplySelf_Onbehalf_dropdown())));
						selfbehalf.selectByIndex(i);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	public void select_Authority_act(int i)
	{ try { driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select authority=new Select(driver.findElement(By.xpath(conf.Authority_Act_dropdown())));
			authority.selectByIndex(i);  }
			catch(Exception e)
			{ e.printStackTrace(); }
	}
	
	public void select_RepresentPerson(int i)
	{ try { driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select Rep_Person=new Select(driver.findElement(By.xpath(conf.Rep_Person_dropdown())));
			Rep_Person.selectByIndex(i); 
			} 
			catch(Exception e)
			{ e.printStackTrace(); }
	}
	
	public void tickdelegationcheckbox()
	{
		try { driver.findElement(By.xpath(conf.tick_delegation())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void FirstNamedelegationTextbox(String Sheetname,int a,int b)
	{
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			driver.findElement(By.xpath(conf.FirstNamedelegation())).click();
		
		driver.findElement(By.xpath(conf.FirstNamedelegation())).sendKeys("9876fdhgdhdhd");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.findElement(By.xpath(conf.nextbtn2())).click(); //  Clicks NEXT button After entering data to check alphanumaric should not allow in First name
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); 
		String Actual_result1 = driver.findElement(By.xpath(conf.Delegation_Firstname_Alphanumaric_check())).getText();
		Assert.assertEquals(Actual_result1 , Delegation_FirtName_Alphanumaric_ExpRes, " --(Delegation FirstName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
		driver.findElement(By.xpath(conf.FirstNamedelegation())).clear();
		driver.findElement(By.xpath(conf.FirstNamedelegation())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,Sheetname,a,b));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void LastNamedelegationTextbox(String SheetName,int a,int b)
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.findElement(By.xpath(conf.LastNamedelegation())).sendKeys("9876fdhgd32432hd");
			js.executeScript("window.scrollBy(0, 1000)"); 
			driver.findElement(By.xpath(conf.nextbtn2())).click();                               //  Clicks NEXT button After entering data to check alphanumaric should not allow in First name
			js.executeScript("window.scrollBy(0, -1000)"); 
			String Actual_result2 = driver.findElement(By.xpath(conf.Delegation_Lastname_Alphanumaric_check())).getText();
			Assert.assertEquals(Actual_result2 , Delegation_LastName_Alphanumaric_ExpRes, " --(Delegation LastName field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Firstname.  
			driver.findElement(By.xpath(conf.LastNamedelegation())).clear();
		driver.findElement(By.xpath(conf.LastNamedelegation())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,b));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public void AddressdelegationTextbox(String SheetName,int a, int b, int c)
	{
		try { 
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.DelegationPostcode())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,b));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.DelegationGObutton())).click();
			Select address=new Select(driver.findElement(By.xpath(conf.Delegationselectaddress())));
			wait=new WebDriverWait(driver, 20);
			int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,SheetName,a,c));
			address.selectByIndex(s_value);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//address[@id='addressTag_address_lbe_hiddendelegateaddresscitizen']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.hiddendelegateaddresstagcitizen())));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}	
	

	//-------------------------------From second Page onwards- NEXT buttons----------------------------
	
	public void NEXT_2()
	{try { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conf.nextbtn2())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
		{ e.printStackTrace(); }	}
	
	
	//-----------------------------From second Page onwards- Save and Exit buttons------------------------
	
	public void SAVE_AND_EXIT_2()
	{try { driver.findElement(By.xpath(conf.SaveExit())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	//----------------------------From second Page onwards- Previous buttons------------------------------
	public void PREVIOUS_1()
	{try { driver.findElement(By.xpath(conf.Previous_btn())).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); }	}
	

	//-----------------------------------Address look_up for All the Pages-------------------------------------------

	public void Postcode_SelectAddress(String sheetname,int a,int b,int c)
	{
		try { driver.findElement(By.xpath(conf.enterpostcode())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b));
				driver.findElement(By.xpath(conf.clickGo())).click();
				wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.PostcodeAddress_Options())));		
				Select address=new Select(driver.findElement(By.xpath(conf.PostcodeAddress_Options())));
				int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,c));
				address.selectByIndex(s_value);						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.PostcodeAddress_Options_selected())));
				
			}
		catch(Exception e)
		{ e.printStackTrace(); }	
	}
	
	public void PostcodeOnbehalf_SelectAddress(String sheetname,int a,int b,int c)
	{
		try { driver.findElement(By.xpath(conf.enterpostcodeonbehalf())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b));
				driver.findElement(By.xpath(conf.clickOnbehalf_Go())).click();
				wait=new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.Onbehalf_address_Option())));		
				Select address=new Select(driver.findElement(By.xpath(conf.Onbehalf_address_Option())));
				int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,c));
				address.selectByIndex(s_value);						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.Onbehalf_selected_Address())));
				
			}
		catch(Exception e)
		{ e.printStackTrace(); }	
	}
	
	
	//---------------------------------------------------------------Upload Documents-------------------------------
	
	public void Uploadedocument()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.ADDFiles_btn())).click();
			driver.findElement(By.xpath(conf.ChooseFile_btn())).sendKeys(UploadFilepath+Uploaddocument);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.Addfile_Popup_btn())).click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			driver.navigate().refresh();
		}
		catch(Exception e)
		{  e.printStackTrace(); }
	}
	
	
	public void PopupCancel()
	{try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.PopupCancel_btn())).click(); 
	}
	
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	//------------------------------------------------Description page NEXT button----------------------------------------

	public void Click_StartForm()   
	{ try { 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conf.Nextbtn())).click();
		
			}
		catch(Exception e)
			{ e.printStackTrace(); }	}
	
	//------------------------------------------If Customer willing to  enter CTA manually-------------------------
	
	public void tickboxCouncilTaxAccNo()
	{
		try { driver.findElement(By.xpath(conf.tickboxCTA())).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	
	//----------------------------------------Customer Received summons YES or NO--------------------------
	  
	public void Select_summons()
	{ 
		try {  Select summons=new Select(driver.findElement(By.xpath(conf.dropdownsummons())));
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			summons.selectByIndex(1);  }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	public void ClickCheckBox()
	{try { driver.findElement(By.xpath(conf.CheckBox())).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
	catch(Exception e)
	{ e.printStackTrace(); } } 
	
	public void ClickSubmit_btn()
	{try { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(conf.Submit_btn())).click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		 WebElement element = driver.findElement(By.xpath(conf.Submit_btn()));     
	        js.executeScript("arguments[0].click()", element);	
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	catch(Exception e)
		{ e.printStackTrace(); } }
	
//------------------------------------------------- Page Heading Text ------------------------------------------------------------
	
	public String Page_heading()
	{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
		return Heading1;	
	}
	
	public String Declarationheading()
	{ 
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.Declarationheadingtext()), "Supporting information and declaration"));
		String Heading1= driver.findElement(By.xpath(conf.Declarationheadingtext())).getText();
		return Heading1 ;	}
	
	public String Delegationheading()
	{   
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.Delegationheadingtext()), "Please complete details of the person you wish to act on behalf of."));
		String Heading2= driver.findElement(By.xpath(conf.Delegationheadingtext())).getText();		
		return Heading2 ;	}

	//------------------------------------------------Submition Page------------------
	
		public void ClickGotohome_btn()
		{try { JavascriptExecutor js = (JavascriptExecutor) driver;
		 		js.executeScript("window.scrollBy(0, -250)");  
		 	//	driver.findElement(By.xpath(conf.Gotohome_btn())).click();
		 	
		 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		 		 WebElement element = driver.findElement(By.xpath(conf.Gotohome_btn()));     
			        js.executeScript("arguments[0].click()", element);	
			}
		catch(Exception e)
			{ e.printStackTrace(); } }
		
		
		public String Casenumber(String Casenumber)
		{try { Casenumber = driver.findElement(By.xpath(conf.Casenumber())).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
		catch(Exception e)
		{ e.printStackTrace(); } 
		return Casenumber; }
		
		public String Servicesummaryheading()
		{
			wait=new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.Servicesummary_txt()), "Service summary"));
			String Servicesummarytxt= driver.findElement(By.xpath(conf.Servicesummary_txt())).getText();		
			return Servicesummarytxt ;	
		}


		
		
		
		
//----------------------------------------------------------------------------------------------------------------------------
//---------------------------------------DYNAMICS Utilitis-------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

	public void Open_UAT_DYNAMICS_URL() 
	{		
		try { 	driver.get(DynCRM.getURL());  } 
		catch (Exception e) {  e.printStackTrace();  }
	}
	
	
	
	
	
	
	
	
	
	
	
}
