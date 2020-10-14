package com.hrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.testcases.LoginPageTest;
import com.hrm.utils.TestUtil;

public class TestBase {
	
 public static WebDriver driver;
 public static Properties pro	;
 public static Logger log;
 
	public TestBase() {

		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\config\\log4j.xml");
		 log=Logger.getLogger(TestBase.class);
		 pro=new Properties();
		FileInputStream fi;
		try {
			fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\config\\data.properties");
			pro.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		String browserName=pro.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);	
		
		driver.get(pro.getProperty("url"));
	}
}
