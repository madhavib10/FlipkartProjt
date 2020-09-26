package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase

{
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	

	//################################################
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\FlipkartTask\\src\\main\\java\\Config\\config.properties");
			prop.load(ip);
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","C:\\eclipse\\geckodriver.exe");
			 driver= new FirefoxDriver();
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); 
	}
}
