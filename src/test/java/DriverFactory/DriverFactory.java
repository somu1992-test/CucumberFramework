package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static WebDriver driver=null;
	
	public static void initializeBrowser(String browserName) 
	{
		if(browserName.equals("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(options);
		}else if(browserName.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) 
		{
			driver=new EdgeDriver();
		}
	}
	
	public static WebDriver getDriver() 
	{
		return driver;
	}

}
