package lbe.digitaltransformation.Myaccount.pages;



	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;

	import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
	import lbe.digitaltransformation.Utility.ExcelReadWrite;
	import lbe.digitaltransformation.Utility.Utility;

	
	
	
	
	public class MyAccountClassV 
	
	{

		ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
		
		 WebDriver driver;
		 WebDriverWait wait;
		 SoftAssert s_assert= new SoftAssert();
		 
		 ExtentTest logger;
		 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
		 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
			
		
		public MyAccountClassV(WebDriver ldriver) 
		{   		this.driver = ldriver;    		}
		
		
		//Page Heading Text
		
		public String AccountNumberheading()
		{   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			wait=new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.heading1text())));
			wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.heading1text()), "Account numbers"));
		
			String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
			return Heading1 ;		
		}
	  
		public String AccountDetailsPageheading()
		{   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.heading1text()), "Account details"));
		
			String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
			return Heading1 ;		
		}
		
		public String Appdetailsheading()
		{   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.heading1text()), "Application details"));
		
			String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
			return Heading1 ;		
		}
		
		
	//--------------------------------Class V----------Is this application-----------------------	
		
//		public void Verify_ClassV_Service_titlepage() {
//			try {
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				Assert.assertEquals(driver.getTitle(), conf.verifytitleclassV());
//				
//			} catch (Exception e) {
//			e.printStackTrace();	}	}
		
		public void VerifyMyAccountApplyself() {
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertEquals(driver.getTitle(), conf.verifytitleclassV());
				
			} catch (Exception e) {
			e.printStackTrace();	}	}
		
	//--------------------------Account number------------------------------------------	

//		public void CTAccountnumber()
//		{ try { driver.findElement(By.xpath(conf.Acc_num())).sendKeys("102030"); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}

	//----------------------Class V-------Account details----------------------------
		
		public void FirstNameofdiplomat(String sheetname, int a, int b)
		{ try { driver.findElement(By.xpath(conf.FirstNamediplomat_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void LastNameofdiplomat(String sheetname, int a, int b)
		{ try { driver.findElement(By.xpath(conf.LastNameofdiplomat_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
//		public void telphonenumber1()
//		{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,5)); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
//		public void emailaddress1()
//		{ try { driver.findElement(By.xpath(conf.emailaddresstxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,10)); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}

	
		//-----------------------------------------Class V Application details page--------------------------------	 
		
		public void Account_nxt_btn()
		{ try { driver.findElement(By.xpath(conf.nextbtn2())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		
		public void Residence_UnitedKingdom1(int a)
		{ try { Select Residence_UnitedKingdom=new Select(driver.findElement(By.xpath(conf.Residence_UnitedKingdom())));
		Residence_UnitedKingdom.selectByIndex(a); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		

		public void tenancy_agreement1(int a)
		{ try { Select tenancy_agreement=new Select(driver.findElement(By.xpath(conf.tenancyagreement())));
		tenancy_agreement.selectByIndex(a); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}

		
		public void UK_diplomat(String sheetname, int a, int b) {
			{ try { 
			driver.findElement(By.xpath(conf.UKdiplomat())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,8)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
			
		}
		
		public void Diplomatic_rank(String sheetname, int a, int b)
		{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.Diplomatic_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,9)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		

		public void Countryinternational_organisation(String sheetname, int a, int b) {
			// TODO Auto-generated method stub
			{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.Countryinternational_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,10)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		}			
		public void British_citizen1(int a) {
			{ try { Select British_citizen=new Select(driver.findElement(By.xpath(conf.British_citizen())));
			British_citizen.selectByIndex(a); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
			catch(Exception e)
			{ e.printStackTrace(); }	}

		}	
		public void UK_resident1(int a) {
			{ try { Select UK_resident=new Select(driver.findElement(By.xpath(conf.UK_resident())));
			UK_resident.selectByIndex(a); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
			catch(Exception e)
			{ e.printStackTrace(); }	}
		}
		
		
		
		
		
		//---------------------------------------------------------------------------------------------------------
		
		
//		public void onbehalfFirstname()
//		{ try { driver.findElement(By.xpath(conf.onbehalffirstnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,6)); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
//		public void onbehalflastname()
//		{ try { driver.findElement(By.xpath(conf.onbehalflastnametxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,7)); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
//		public void onbehalfPostcodeAddress()
//		{ try { driver.findElement(By.xpath(conf.enteronbehalfpostcode())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sheet2Name,1,8)); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
//		public void onbehalfClick_Go()
//		{ try { driver.findElement(By.xpath(conf.clickonbhalfGo())).click(); }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
//		public void onbehalfselectAddress()
//		{ try {  Select address=new Select(driver.findElement(By.xpath(conf.selectonbehalfaddress())));
//		address.selectByIndex(6);  }
//		catch(Exception e)
//		{ e.printStackTrace(); }	}
//		
		public void telphonenumber()
		{
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;			
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(conf.nextbtn2())).click(); 
				String Actual_result = driver.findElement(By.xpath(conf.Mobilenumber_Invalid_check())).getText();
				s_assert.assertEquals(Actual_result , ContactNumber_Invalid_ExpectRes, " --(Contact Number field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Contact Number.  			
			    js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
				driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys("9876fdhgdhdhd");
				driver.findElement(By.xpath(conf.nextbtn2())).click(); 
				s_assert.assertEquals(Actual_result , ContactNumber_Invalid_ExpectRes, " --(Contact Number field value is Invalid (OR) Something went wrong here please check)-- " ); //Checks for Alphanumaric should not allow in Contact Number.  
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
				driver.findElement(By.xpath(conf.telphonenumbertxt())).clear();
				driver.findElement(By.xpath(conf.telphonenumbertxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,1,3)); 
				wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.nextbtn2())));
				s_assert.assertAll();	
			}
			catch(Exception e)
			{ e.printStackTrace(); }	}
		
		public void emailaddress()
		{ try { driver.findElement(By.xpath(conf.emailaddresstxt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,1,6)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		public void Nextbtn()
		{ try { driver.findElement(By.xpath(conf.nextbtn2())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		public void MandatoryFieldCheck()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.nextbtn2())).click();      //  Clicks NEXT button before Enter data to check mandatory message displayed or not
			wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(conf.mandatorycheck()), "The form could not be submitted for the following reasons:"));
			String Actual_result = driver.findElement(By.xpath(conf.mandatorycheck())).getText();
			s_assert.assertEquals(Actual_result , Mandatory_ExpectedResult);
			s_assert.assertAll();
		}
		
		public void Accountdetailspage_nextbtn()
		{ try { 		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.nextbtn2())).click();
		}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void Accountdetailspage_SaveExit()
		{ try { driver.findElement(By.xpath(conf.SaveExit())).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		
		//------------------------------------Application Details Page---------------------------------------------------------------
		
		
		public void Name_Address(String sheetname)
		{ try { driver.findElement(By.xpath(conf.NameofPrison_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,13)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void PrisonerNumber(String sheetname)
		{ try { driver.findElement(By.xpath(conf.PrisonerNumber_txt())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,14)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void PersonDOB(String sheetname)
		{ try { driver.findElement(By.xpath(conf.DOB_date())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,15));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void RemandedinCustody()
		{ try { Select custody=new Select(driver.findElement(By.xpath(conf.Custody_dpd())));
		custody.selectByIndex(1); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void ExpectedReleasedate(String sheetname)
		{ try { driver.findElement(By.xpath(conf.Releasedate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,1,16));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		
		
		//--------------------------------Citizen Documents Page----------------------------------
		
		public void ADDFiles()
		{try { driver.findElement(By.xpath(conf.ADDFiles_btn())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void ChooseFile()
		{try { driver.findElement(By.xpath(conf.ChooseFile_btn())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void PopupAddfile()
		{try { driver.findElement(By.xpath(conf.Addfile_Popup_btn())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}	
		
		public void PopupCancel()
		{try { driver.findElement(By.xpath(conf.PopupCancel_btn())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		
		
		//------------------------------------------------Review Request Details------------------
		
		public void ClickCheckBox()
		{try { driver.findElement(By.xpath(conf.CheckBox())).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
		catch(Exception e)
		{ e.printStackTrace(); } } 
		
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
		
		public void ClickSubmit_btn()
		{try { 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(conf.Submit_btn())).click();
			 }
		catch(Exception e)
			{ e.printStackTrace(); } }

		
		
		//------------------------------------------------Submition Page------------------
		
	
		
		
		public String ClassV_Casenumber(String Casenumber)
		{try { Casenumber = driver.findElement(By.xpath(conf.Casenumber())).getText();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
		catch(Exception e)
		{ e.printStackTrace(); }
		return Casenumber; }
		
		
		

	}



	
	
	
	
	
