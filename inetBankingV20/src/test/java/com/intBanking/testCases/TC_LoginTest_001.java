package com.intBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.intBanking.pageObjects.HomePage;
import com.intBanking.pageObjects.LoginPage;
import com.intBanking.testBase.TestBase;

public class TC_LoginTest_001 extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public TC_LoginTest_001() throws IOException  {
		super();
		
	}
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) throws IOException{
	initialisation(br);
	logger.info("url opened");
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyBankLogo(){
		boolean flag=loginpage.validatePageLogo();
		Assert.assertTrue(flag);
		logger.info("verified login page");
	}
	@Test(priority=2)
	public void loginTest() throws IOException{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void hompageTest() {
		if(driver.getPageSource().contains("Guru9999 Bank Manager HomePage")){
			logger.info("login test passed");
			Assert.assertTrue(true);
		} 
		else
		{
			captureScreen("TC_LoginTest_001");
			logger.info("login test failed");
			Assert.assertTrue(false);
			
		}   
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
}
