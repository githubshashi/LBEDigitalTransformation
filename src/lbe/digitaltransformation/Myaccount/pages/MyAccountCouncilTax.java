package lbe.digitaltransformation.Myaccount.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;

public class MyAccountCouncilTax {

	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	
	 WebDriver driver;
	
	public MyAccountCouncilTax(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	
	public void VerifyCounciltaxtitlepage()
	{  try { 
		
		Assert.assertEquals(driver.getTitle(),conf.Counciltaxpagetitle());
	}
	catch(Exception e)
	{ e.printStackTrace(); }
		
	}
	
	
	public void ClickonclassVlink()
	{
		try { 	
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     driver.findElement(By.xpath(conf.classVlink())).click();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}

	
	
	
	//Unoccupied properties sub services
	
	public void ClickVaccentpropertyDiscountApplication()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.VPDAlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}
	
	public void ClickonclassTlink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classTlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}
	
	public void ClickonclassElink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classElink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}

	public void ClickonclassJlink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classJlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}

	public void ClickonclassQlink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classQlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}

	public void ClickonclassHlink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classHlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}

	public void ClickonclassRlink()
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.findElement(By.xpath(conf.classRlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e)
		{  			e.printStackTrace();   		}
	}


	public void ClickonclassKlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classKlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void ClickonclassFlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classFlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void ClickonclassIlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classIlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void ClickonclassBlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classBlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void ClickonclassLlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classLlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void Clickonclassdlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classDlink())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}
	
	public void ClickonclassGlink()
	{
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			driver.findElement(By.xpath(conf.classG_link())).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
		catch(Exception e) 
		{			e.printStackTrace();		}	
	}




}
