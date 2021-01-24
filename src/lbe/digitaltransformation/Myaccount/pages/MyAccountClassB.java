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

public class MyAccountClassB
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
	 
	 public MyAccountClassB(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
		 public void Enter_Organisation_Name(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_Name_Organisation())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_FirstName_MakingClaim_onbehalf_organisation(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_FirstName_MakingClaim_onbehalf_organisation())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	} 
	
		 public void Enter_LastName_MakingClaim_onbehalf_organisation(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_LastName_MakingClaim_onbehalf_organisation())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_Organisation_liable_CT_Housing(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_Organisation_liable_CT_Housing())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 
		 public void Enter_Date_PropertyVacated(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_Date_PropertyVacated())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_Property_OwnedLeased_organisation(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_Property_OwnedLeased_organisation())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		
		 
		 public void Select_BodyEstablishedCharitable(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_BodyEstablishedCharitable())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 public void Select_LastTenant_social_affordableRent(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_LastTenant_social_affordableRent())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 public void Select_CharitableObjectives_Organisation(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_CharitableObjectives_Organisation())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		
		 
		 public void Enter_FirstName_PreviousTenant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_FirstName_PreviousTenant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_LastName_PreviousTenant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_LastName_PreviousTenant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_Property_Reoccupied(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassB_Property_Reoccupied())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 
		 
		 public void Enter_FirstName_NewTenant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_FirstName_NewTenant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_LastName_NewTenant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_LastName_NewTenant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_NewTenant_StartDate(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_NewTenant_StartDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_Details_property_used(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassB_Details_property_used())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	 
	
}
