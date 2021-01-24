package lbe.digitaltransformation.Myaccount.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lbe.digitaltransformation.Utility.ConfigReaderMyAccount;
import lbe.digitaltransformation.Utility.ExcelReadWrite;
import lbe.digitaltransformation.Utility.Utility;



public class MyAccountSignIn {

	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	Properties prop;
	
	 WebDriver driver;
	 WebDriverWait wait;	
	 
	public MyAccountSignIn(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	public void SignInPageTitle()
	{
		try {		
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='signInHeading']")));
			
			Assert.assertEquals(driver.getTitle(), conf.SignInPageTitle());	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void login(int a, int b)
	{		
		try { 
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String SignInpageheading = driver.findElement(By.xpath("//div[@class='signInHeading']")).getText();
			Assert.assertEquals(SignInpageheading, "Sign in to My Account");		
		//	int lastRowNum=ExcelReadWrite.Excelcount(Utility.excelfilepath, Utility.Sheet1Name); //Total number of rows
			
			driver.findElement(By.xpath(conf.username())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails, a,b));			
			driver.findElement(By.xpath(conf.Password())).sendKeys(ExcelReadWrite.getCellData(Utility.excelfilepath, Utility.Sh_CommonDetails,a,a));			
			JavascriptExecutor js = (JavascriptExecutor) driver;
					
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  //This will scroll the web page till end.
			
		        WebElement element = driver.findElement(By.xpath(conf.SignInbutton()));
		        JavascriptExecutor executor = (JavascriptExecutor)driver;
		        executor.executeScript("arguments[0].click()", element);
		        
			//driver.findElement(By.xpath(conf.SignInbutton())).click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


	
	public void facebookReg()
	{
		try {
			driver.findElement(By.xpath("")).click(); // Click on the facebook icon
		}
		catch(Exception e)
		{
			
		}
	}
	public void LinkedInReg()
	{
		try {
			driver.findElement(By.xpath("")).click(); // Click on the LinkedIn icon
		}
		catch(Exception e)
		{
			
		}
	}
	public void MicrosoftReg()
	{
		try {
			driver.findElement(By.xpath("")).click(); // Click on the Microsoft icon
		}
		catch(Exception e)
		{
			
		}
	}
	public void GoogleReg()
	{
		try {
			driver.findElement(By.xpath("")).click(); // Click on the Google icon
		}
		catch(Exception e)
		{
			
		}
	}
	
	
}
