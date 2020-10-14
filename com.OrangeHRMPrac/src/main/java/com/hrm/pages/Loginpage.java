package com.hrm.pages;


import org.openqa.selenium.support.PageFactory;
import com.hrm.base.TestBase;
import com.page.locators.HomepageLocator;
import com.page.locators.LoginPanelLocators;

public class Loginpage extends TestBase implements LoginPanelLocators, HomepageLocator{
	
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String username, String password)
	{
		log.info("Entering Username");
		driver.findElement(Username).sendKeys(username);
		log.info(username+" username is entered");
		log.info("Entering Password");
		driver.findElement(Password).sendKeys(password);
		log.info(password+ "Password entered");
		log.info("Clicing on login button");
		driver.findElement(LoginButton).click();
		log.info("Clicked on login button");
		return new HomePage();
	}
	public boolean ValidateHrmLogo() {
		log.info("Checking is hrm logo is displayed");
		return driver.findElement(HrmLogo).isDisplayed();
	}
	
	
	public String getLoginPanelTitle() {
		
		log.info("Getting login panel title");
		String titile= driver.findElement(LoginPanel).getText();
		log.info("Login page title is "+titile);
		 return titile;
	}
}
