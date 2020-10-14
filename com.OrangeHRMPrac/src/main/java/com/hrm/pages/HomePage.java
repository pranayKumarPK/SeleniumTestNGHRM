package com.hrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;
import com.page.locators.HomepageLocator;
import com.page.locators.LoginPanelLocators;

import com.page.locators.MyProfilePageLocator;

public class HomePage extends TestBase implements HomepageLocator,LoginPanelLocators,MyProfilePageLocator {

	public HomePage() {
	
		PageFactory.initElements(driver, this);
		
	}
	public String getHomePageTitle() {
		String PageTitle= driver.findElement(Title).getText();
		log.info("Title of HomePage is "+PageTitle);
		return PageTitle;
	}
	public LeavePage clickOnLeaveButton() {
		log.info("Clicking on leave button");
		driver.findElement(LeaveButton);
		log.info("Clicked on Leave Button");
		return new LeavePage();
	}
	public Loginpage LogOut() {
		log.info("Clcking on MyProfile link");
		driver.findElement(MyProfile).click();
		log.info("Clicked on MyProfile link");
		log.info("Clicking on logOut link");
		driver.findElement(LogOutLink).click();
		log.info("Clicked on logOut link");
		return new Loginpage();
	}
	public DisciplinePage clickOnDisciplinePage() {
		log.info("Clicking on Discipline page");
		driver.findElement(Discipline).click();
		log.info("Clicked on Discipline page");
		log.info("Clicking on DisciplineCase page");
		driver.findElement(DisciplinaryCase).click();
		log.info("Clicked on DisciplinaryCase page");
		return new DisciplinePage();
	}
	public RecruitmentPage clickOnRecruitmentPage() {
		log.info("Clicking on Recruitment page");
		driver.findElement(Recuirment).click();
		log.info("Clicked on Recruitment page");
		return new RecruitmentPage();
	}
}
