package com.hrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.HomePage;
import com.hrm.pages.Loginpage;

public class LogoutPageTest extends TestBase {

	HomePage homepage;
	Loginpage loginpage;
	public LogoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
	//	homepage=new HomePage(driver);
		loginpage=new Loginpage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	@Test(priority=1)
	public void LogOut() {
		homepage.LogOut();
		Assert.assertEquals(loginpage.getLoginPanelTitle(), "LOGIN Panel");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
