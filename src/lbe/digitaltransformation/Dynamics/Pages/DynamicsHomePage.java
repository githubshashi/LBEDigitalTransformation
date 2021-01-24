package lbe.digitaltransformation.Dynamics.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;


import lbe.digitaltransformation.Utility.ConfigReaderDynamics;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;

public class DynamicsHomePage
{
	
	ConfigReaderDynamics DynCRM = new ConfigReaderDynamics();
	
	WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;
	
	 
	 public DynamicsHomePage(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
		 public void Click_CaseTab()
			{ try { 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement element1 = driver.findElement(By.xpath(DynCRM.ClickCasetab()));
		     	js.executeScript("arguments[0].click()", element1);
				
		     	}
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void Search_Casenumber(String sheetname, int a, int b)
			{ try { 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(DynCRM.Search_dynitem())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, sheetname,a,b));}
			catch(Exception e)
			{ e.printStackTrace(); }	}
		 
		 public void ClickonSearch()
			{ try { 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(DynCRM.Click_Search_icon())).click();}
			catch(Exception e)
			{ e.printStackTrace(); }	}
	
	
	
	

}
