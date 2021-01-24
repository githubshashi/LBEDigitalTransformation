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

public class MyAccountClassR {
	
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	
	 WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	


	 String Mandatory_ExpectedResult="The form could not be submitted for the following reasons:";
	 String MandatoryMobileNumber_ExpectedResult="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 String FirtName_Alphanumaric_ExpectRes="First Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String LastName_Aplhanumaric_ExpectRes="Last Name of person who is being detained - Error: this field should contain alphabetic and permitted characters {-,'} Also, only special characters are not allowed";
	 String ContactNumber_Invalid_ExpectRes="Contact telephone number - Error: this number is not valid. Please re-enter.";
	 
	 public MyAccountClassR(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
		 public void Enter_Name_Owner_pitch_mooring(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassR_Name_Owner_pitchORmooring())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_Property_Boat_Caravan(String sheetname,int a, int b)
			{ try { 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
				Select ln=new Select(driver.findElement(By.xpath(conf.ClassR_Boat_Carvan_dpd())));
				ln.selectByIndex(value);  }
		catch(Exception e)
		{ e.printStackTrace(); }	}

		 
		 public void Enter_Mooring_Pitch_Vacated_Date(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassR_Mooring_Pitch_Vacated_Date())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
}
