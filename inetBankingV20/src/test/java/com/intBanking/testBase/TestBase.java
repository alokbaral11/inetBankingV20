package com.intBanking.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	
	public TestBase() throws IOException{
		logger=Logger.getLogger("inetBanking");
		
			prop=new Properties();
			FileInputStream fi=new FileInputStream("C:/Users/ALOK/workspace/inetBankingV20/Configuration/config.properties");
			prop.load(fi);
		
	}
     
	public static void initialisation(String br){
		
		PropertyConfigurator.configure("Log4j.properties");
		//String browsername=prop.getProperty("browser");
			if(br.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:/chromedriver.exe");
			driver=new ChromeDriver();
		}
			else if(br.equals("fierfox")){
			System.setProperty("webdriver.gecko.driver", "F:/gecodriver.exe");
			driver=new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.get(prop.getProperty("baseUri"));
			
	}
			public void captureScreen(String tname) {
				File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
				try{
				FileUtils.copyFile(source,target);
				}catch(IOException e){
					e.printStackTrace();
				}
				System.out.println("Screenshot Taken");
	}
	
}

























