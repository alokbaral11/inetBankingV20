package com.intBanking.pageObjects;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.intBanking.testBase.TestBase;

public class LoginPage extends TestBase {

	 @FindBy(name="uid")
	  @CacheLookup
	  WebElement txtUserName; 
	  
	  @FindBy(name="password")
	  @CacheLookup
	  WebElement txtPassword;
	  
	  @FindBy(name="btnLogin")
	  @CacheLookup
	  WebElement btnLogin;
	  
	  @FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[1]/a/img")
	  @CacheLookup
	  WebElement bankLogo;
	  
	  public LoginPage() throws IOException{
			PageFactory.initElements(driver, this);
	  }
	
	public boolean validatePageLogo(){
		return bankLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) throws IOException{
		
		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}

}














































