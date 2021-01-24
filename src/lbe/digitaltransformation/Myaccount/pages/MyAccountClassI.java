package lbe.digitaltransformation.Myaccount.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class MyAccountClassI 
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
	 
	 public MyAccountClassI(WebDriver ldriver)
	 { this.driver=ldriver; }
	
	 
	 
	//------------------------------------Account Details Page---------------------------------------------------------------
	 
	 public void Enter_Firstname_person_left_property(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassI_FirstName_leftPropertyReceiveCare())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_Lastname_person_left_property(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassI_LastName_leftPropertyReceiveCare())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	} 
	 
	 public void Enter_Date_PropertyOccupied(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassI_PropertyUnoccupied_Date())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Select_Owner_Tenant_UnoccupiedProperty(String excelfilepath,String sheetname,int a,int b)
		{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b)); 
		Select ln=new Select(driver.findElement(By.xpath(conf.ClassI_OwnerTenant_Unoccupied_property())));
			ln.selectByIndex(value);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void SelectAddress_Person_receiving_care(String excelfilepath, String sheetname,int a,int b,int c)
		{
			try { driver.findElement(By.xpath(conf.ClassI_Address_Person_receiving_care_Postcode())).sendKeys(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b));
					driver.findElement(By.xpath(conf.ClassI_Address_Person_receiving_care_GO())).click();
					wait=new WebDriverWait(driver, 15);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.ClassI_Address_Person_receiving_care_dpd())));				
					Select address=new Select(driver.findElement(By.xpath(conf.ClassI_Address_Person_receiving_care_dpd())));
					int s_value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,c));
					address.selectByIndex(s_value);								
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.ClassI_Address_Person_receiving_care_Selectedfinal())));
					
				}
			catch(Exception e)
			{ e.printStackTrace(); }	
		}
	 
	 public void Enter_Date_PersonMovedAddress(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassI_PersonMovetoAddress_Date())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Select_ResonForCare(String excelfilepath, String sheetname,int a,int b)
		{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int value=Integer.parseInt(ExcelReadWrite.getCellData(excelfilepath,sheetname,a,b)); 
		Select ln=new Select(driver.findElement(By.xpath(conf.ClassI_WhyCareProvided())));
			ln.selectByIndex(value);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_Describe_NatureOfCare(String sheetname,int a,int b)
		{ try { driver.findElement(By.xpath(conf.ClassI_DescribeNatureOfCare())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
