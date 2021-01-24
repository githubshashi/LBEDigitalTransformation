package lbe.digitaltransformation.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	ConfigReaderMyAccount conf = new ConfigReaderMyAccount();
	WebDriver driver;
	
	public BrowserFactory(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public WebDriver startBrowser( ) 
	{	
		
		if (conf.getBrowsername().equals("firfox"))
		{
		//if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (conf.getBrowsername().equals("IE")) {
			driver = new InternetExplorerDriver();

		} else if (conf.getBrowsername().equals("chrome")) {
			System.setProperty(conf.getDriverValue(), conf.getDriverPath());	
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		//driver.get(url);
		return driver;
		
	}	

}
