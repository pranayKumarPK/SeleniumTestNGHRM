package com.hrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DisciplinePage;
import com.hrm.pages.HomePage;
import com.hrm.pages.Loginpage;
import com.hrm.utils.TestUtil;

public class AddDisciplinaryCase extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	DisciplinePage disciplinepage;
	String sheetName="DisciplineCase";
	public AddDisciplinaryCase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		 loginpage=new Loginpage();
		 homepage=new HomePage();
		 
		 homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		 disciplinepage= homepage.clickOnDisciplinePage();
		 
		
	}
	@Test(priority=1)
	public void validateDisciplineCaseTitle() {
		Assert.assertEquals(disciplinepage.verifyDisciplinePageTitle(),"Disciplinary Cases");
		
	}
	@Test(priority=2, dataProvider="getHRMTestData")
	public void addDisciplineCase(String EmpName, String caseName,String Desc) {
		disciplinepage.ClickOnaddDisciplinaryCaseButton();
		disciplinepage.addDisciplineCase(EmpName, caseName, Desc);
		disciplinepage.CloseDisciplinaryCase();
		Assert.assertEquals(disciplinepage.getFirstElementFromTheList(), EmpName);
	}
	@DataProvider
	public Object[][] getHRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
				}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
