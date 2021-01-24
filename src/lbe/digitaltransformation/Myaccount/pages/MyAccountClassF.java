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

public class MyAccountClassF 
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
	 
	 public MyAccountClassF(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
		 public void Enter_FirstNameInformant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_FirstNameInformant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_LastNameInformant(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_LastNameInformant())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 
		 public void Enter_CTADeceasedPerson(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_CTADeceasedPerson())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_FirstName_Deceased(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_FirstName_Deceased())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_LastName_Deceased(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_LastName_Deceased())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_Person_Died_Date(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Person_Died())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_PropertyUnoccupied(String sheetname,int a, int b)
			{ try 
				{	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_PropertyUnoccupied())));
						ln.selectByIndex(value);  }
				catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 public void Select_Furnished_Unfurnished(String sheetname,int a, int b)
			{ try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
					Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_Furnished_Unfurnished())));
					ln.selectByIndex(value);  }
			catch(Exception e)
				{ e.printStackTrace(); }	}
		 
		 public void Enter_DateFurnitureRemoved(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_DateFurnitureRemoved())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_AdministrationGranted(String sheetname,int a, int b)
			{ try {  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
			Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_AdministrationGranted())));
			ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_AdministrationGrantedDate(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_AdministrationGrantedDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_Name_Address_Administrator(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Name_Address_Administrator())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_Name_Address_Solicitor(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Name_Address_Solicitor())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_Deceased_Tenant_Owner(String sheetname,int a, int b)
			{ try {   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
			Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_Deceased_Tenant_Owner())));
			ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 
		 public void Select_TenantEnded_Y_N(String sheetname,int a, int b)
			{ try {   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
			Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_TenancyEnded())));
			ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_TenantEnded_Date(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_TenancyEndDate())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 
		 public void Enter_NameAddress_landlord(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Name_Address_Landlord())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Select_NewOwner_Ownership_Y_N(String sheetname,int a, int b)
			{ try {   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int value=Integer.parseInt(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b)); 
			Select ln=new Select(driver.findElement(By.xpath(conf.ClassF_Administration_Granted_ownership_beneficiarys())));
			ln.selectByIndex(value);  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	
		 public void Enter_OwnerShipTransfered_Date(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Ownership_Transferred())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Enter_NameAddress_NewOwner(String sheetname,int a, int b)
			{ try { driver.findElement(By.xpath(conf.ClassF_Name_Address_NewOwner())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));  }
			catch(Exception e)
			{ e.printStackTrace(); }	}
	
}

