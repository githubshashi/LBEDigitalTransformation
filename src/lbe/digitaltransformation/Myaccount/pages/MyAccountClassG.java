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

public class MyAccountClassG 
{
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	
	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	 
	 
	 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String FirtName_Alphanumaric_ExpectRes="First Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String LastName_Aplhanumaric_ExpectRes="Last Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 
	 public MyAccountClassG(WebDriver ldriver)
	 { this.driver=ldriver; }
	
	
	public String Page_heading()
	{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Heading1= driver.findElement(By.xpath(conf.heading1text())).getText();
		return Heading1;	
	}
	
//	public void Verify_ClassG_Service_titlepage() {
//		try {Assert.assertEquals(driver.getTitle(), conf.verifytitleclassG());
//		} catch (Exception e) {
//		e.printStackTrace();	}	}
	
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
	
	//------------------------------------Account Details Page---------------------------------------------------------------
	public void Enter_FullNameof_Person_Organisation(String sheetname,int a,int b)
	{ try { driver.findElement(By.xpath(conf.ClassG_FullNameofPerson())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	
	
	
	
	//------------------------------------Application Details Page---------------------------------------------------------------
	
		public void Enter_DateOfPropertyUnoccupied(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassG_PropertybecameUnoccupied())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void Select_LegalNotice_Issued(String sheetname,int a,int b)
		{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select ln=new Select(driver.findElement(By.xpath(conf.ClassG_LegalNotice())));
			ln.selectByIndex(a);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void Enter_EffectiveDate(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassG_EffectiveDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
		
		public void Enter_AnyFurtherInformation(String sheetname,int a,int b)
		{ try {driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(conf.ClassG_AnyFurtherInfo())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));
		}
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	
	
	
	
	
	
	
}
