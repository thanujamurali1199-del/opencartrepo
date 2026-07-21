package testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	static HomePage hp;
	static LoginPage lp;
	MyAccountPage ma;
	@Test(groups={"Sanity","Master"},priority=1)
	public void accountLogin() throws IOException {
		logger.info("****** Startign TC_002_LoginTest *****");
		try {
		hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		ma=new MyAccountPage(driver);
		Boolean Myaccountlabelexists=ma.isMyAccountPageExists();
		Assert.assertTrue(Myaccountlabelexists,"myaccount label not exists");
		
		//Assert.assertNotEquals(Myaccountlabelexists, true,"Login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****** Finished TC_002_LoginTest *****");	
	}
	
	@Test(priority=0,groups="Master")
	public void invalidlogin() {
		logger.info("****** Startign TC_002_invalidLoginTest *****");
		try {
			hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			lp=new LoginPage(driver);
			lp.setEmail("hh");
			lp.setPassword("");
			lp.clickLogin();
			ma=new MyAccountPage(driver);
			Boolean invalidlabelexists=lp.isinvalidmsgExists();
			Assert.assertTrue(invalidlabelexists,"Invalid message issue");
			
			//Assert.assertNotEquals(Myaccountlabelexists, true,"Login failed");
			}
			catch(Exception e) {
				Assert.fail();
			}
			logger.info("****** Finished TC_002_InvalidLoginTest *****");
		
	}
	
	
}
