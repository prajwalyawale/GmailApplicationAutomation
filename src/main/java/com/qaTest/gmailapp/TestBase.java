package com.qaTest.gmailapp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qaTest.utils.TestUtil;



public class TestBase
{
	public static WebDriver driver;
    public static Properties prop; 
	public TestBase()
	{
		try {
			prop=new Properties();
			
			//FileInputStream ip=new FileInputStream(System.getProperty("user dir")+"./src/main/java/com/freeHRMS/qa/config/Configuation.properties");
			FileInputStream ip=new FileInputStream("D:\\Workspace2\\GmailApplication\\configTest\\config.properties");
			prop.load(ip);
			//System.out.println(ip);
		} catch (FileNotFoundException e) 
		{
		e.printStackTrace();	
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void initalization() 
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Workspace2/GmailApplication/Driver/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.firefox.driver", "D:/Workspace2/GmailApplication/FireFoxDriver/geckodriver.exe");
		driver=new FirefoxDriver();
					
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Thread.sleep(3000);
		Timeouts pageLoadTimeout = driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	
	}

}