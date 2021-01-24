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

public class MyAccountClassK 
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
	 
	 public MyAccountClassK(WebDriver ldriver)
	 { this.driver=ldriver; }
	
	 
	 public void Enter_FirstName_PropertyVacated(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_FirstName_PropertyVacated())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_LastName_PropertyVacated(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_LastName_propertyVacated())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 
	 
	 public void Select_Owner_Tenant_PropertyUnoccupied(String sheetname,int a, int b)
		{ try 
			{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
				Select ln=new Select(driver.findElement(By.xpath(conf.ClassK_Owner_Tenant_PropertyUnoccupied())));
					ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	 
	 
	 public void Enter_Date_propertyunoccupied(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_Date_propertyunoccupied())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Select_AnyOtherAdultsResides(String sheetname,int a, int b)
		{ try { 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
			Select ln=new Select(driver.findElement(By.xpath(conf.ClassK_AnyOtherAdultsResides())));
			ln.selectByIndex(value);  }
	catch(Exception e)
	{ e.printStackTrace(); }	}
	 
	 public void Enter_FirstName_Residents(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_FirstName_Residents())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_LastName_Residents(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_LastName_Residents())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Select_Person_student(String sheetname,int a, int b)
		{ try 
			{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
				Select ln=new Select(driver.findElement(By.xpath(conf.ClassK_Person_student())));
					ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	 
	 public void Enter_ForwardingAddress(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_ForwardingAddress())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_UniversityCollegeName(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_UniversityCollegeName())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 
	 public void Enter_Course_StartDate(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_Course_StartDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 
	 public void Enter_Course_EndDat(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_Course_EndDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_UniversityCollege_You_Studying(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_UniversityCollege_You_Studying())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_Course_You_StartDate(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_Course_You_StartDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 public void Enter_Course_You_EndDate(String sheetname,int a, int b)
		{ try { driver.findElement(By.xpath(conf.ClassK_Course_You_EndDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
		catch(Exception e)
		{ e.printStackTrace(); }	}
	
	 
}
