package com.hrm.testcases;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.HomePage;
import com.hrm.pages.Loginpage;

public class LoginPageTest extends TestBase {
	Loginpage loginpage;
	HomePage homepage;
	 
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialize();
		 loginpage=new Loginpage();
		 homepage=new HomePage();
		
	}
	@Test(priority=1)
	public void validateHrmLogo() {
		Assert.assertEquals(loginpage.ValidateHrmLogo(),true);
		
	}
	@Test(priority=2)
	public void login() {
		loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		Assert.assertEquals(homepage.getHomePageTitle(), "Dashboard");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
