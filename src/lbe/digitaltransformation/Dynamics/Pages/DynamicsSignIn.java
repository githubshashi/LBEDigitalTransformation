package lbe.digitaltransformation.Dynamics.Pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lbe.digitaltransformation.Utility.ConfigReaderDynamics;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;


public class DynamicsSignIn 
{
	ConfigReaderDynamics DynCRM = new ConfigReaderDynamics();
	
	Properties prop;

	 WebDriver driver;
	 ExtentTest logger;
	 WebDriverWait wait;
	 
	 String Signintitle="Sign in to your account";
	 
		public DynamicsSignIn(WebDriver ldriver) {
			this.driver = ldriver;
		}
		
	
		public void Dynamicslogin(int a, int b, int c)
		{		
			try { 
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Assert.assertEquals(Signintitle,driver.getTitle());		
				JavascriptExecutor js = (JavascriptExecutor) driver;
				driver.findElement(By.xpath(DynCRM.username())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails, a,b));			
										       
			     	WebElement element1 = driver.findElement(By.xpath(DynCRM.NEXTbutton()));
			     	js.executeScript("arguments[0].click()", element1);
			     
			    driver.findElement(By.xpath(DynCRM.Password())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,a,c));  
			    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			      
			     	WebElement element2 = driver.findElement(By.xpath(DynCRM.SignInbutton()));
			     	js.executeScript("arguments[0].click()", element2);   

			     	WebElement element3 = driver.findElement(By.xpath(DynCRM.NO_button()));
			     	js.executeScript("arguments[0].click()", element3);   
			        
			    //logger.log(LogStatus.INFO, "Successfully logged in to Dynamics CRM");
			    
			   
			    wait=new WebDriverWait(driver, 200);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DynCRM.Search_LBE_Application())));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(DynCRM.searchLBE_APPFrame()) ));
				
				WebElement element4 = driver.findElement(By.xpath(DynCRM.Click_LBE_Application()));
		     	js.executeScript("arguments[0].click()", element4); 
			}
			catch(Exception e)
			{
				//logger.log(LogStatus.INFO, " log in Error- Something went wrong /n");
				e.printStackTrace();
				
			}
			
		}
	
	
}
