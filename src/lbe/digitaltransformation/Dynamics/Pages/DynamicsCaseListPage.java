package lbe.digitaltransformation.Dynamics.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import lbe.digitaltransformation.Utility.ConfigReaderDynamics;

public class DynamicsCaseListPage {
	
	
	
	ConfigReaderDynamics DynCRM = new ConfigReaderDynamics();
	
	WebDriver driver;
	 WebDriverWait wait;
	 ExtentTest logger;

	 public DynamicsCaseListPage(WebDriver ldriver)
	 { this.driver=ldriver; }
	 
	 
	 public void doubleclickonCasenumbetr()
		{ try { 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions actions = new Actions(driver);	
			WebElement element1 = driver.findElement(By.xpath(DynCRM.doubleClick_CaserefNo()));
	     	//js.executeScript("arguments[0].click()", element1);
	     	//driver.findElement(By.xpath(DynCRM.doubleClick_CaserefNo())).sendKeys(Keys.ENTER); 
			
	     
	     	
	     	actions.doubleClick(element1).perform();	
	     	
	     	
	     	}
		catch(Exception e)
		{ e.printStackTrace(); }	}
	 
	 
	 
	 
	 
}
