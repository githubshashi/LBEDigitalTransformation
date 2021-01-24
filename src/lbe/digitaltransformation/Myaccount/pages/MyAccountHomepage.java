package lbe.digitaltransformation.Myaccount.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;



public class MyAccountHomepage {

	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	Properties prop;
	
	
	 WebDriver driver;
	 WebDriverWait wait;
	 
	public MyAccountHomepage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void homePageTitleVerification() {
		try {
			Assert.assertEquals(driver.getTitle(), conf.homePageTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void HomeIcon()
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.Homeicon_Click())).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickonSignIn()
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.homepageSignInbutton())).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void ClickonCounciltax()
	{
		try {
			
			driver.findElement(By.xpath(conf.Counciltaxtab())).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		catch (Exception e)
		{ e.printStackTrace(); }
	}
	public void Clickonwhatservicebutton()
	{
		try { 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.whatservicebutton())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch (Exception e)
		{ e.printStackTrace(); }
	}
}
