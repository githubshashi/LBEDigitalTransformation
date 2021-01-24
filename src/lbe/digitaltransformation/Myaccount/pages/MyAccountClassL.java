package lbe.digitaltransformation.Myaccount.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class MyAccountClassL {
	
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	
	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	


	 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String FirtName_Alphanumaric_ExpectRes="First Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String LastName_Aplhanumaric_ExpectRes="Last Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 
	 public MyAccountClassL(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
	//------------------------------------Account Details Page---------------------------------------------------------------
	 
		 public void Enter_Firstname_CT(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_FirstName())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	 
		 public void Enter_Lastname_CT(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_LastName())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	 
		//------------------------------------Application Details Page---------------------------------------------------------------
		 
		 public void Enter_Property_Unoccupied_Date(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_Property_Unoccupied())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_PropertyUnfurnished(String excelfilepath,String sheetname,int a,int b)
			{ try 
			{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				int value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b)); 
				Select ln=new Select(driver.findElement(By.xpath(conf.ClassL_PropertyUnfurnished())));
					ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_DateOfRepossesion(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_Repossesiondate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_Bank_Building_reposs(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_Bank_Building_reposs())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_further_Enquiry(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_further_Enquiry())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_TanencyStartDate(String sheetname,int a,int b)
			{ try { driver.findElement(By.xpath(conf.ClassL_TanencyStart())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 
		 
}
