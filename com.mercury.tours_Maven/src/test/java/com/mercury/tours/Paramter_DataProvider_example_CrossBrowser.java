package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramter_DataProvider_example_CrossBrowser extends application_testData{
	WebDriver driver;
	@Test (dataProvider="Sign_On")
	  public void Sign_On(String uname,String pwd) throws InterruptedException {
		  	driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.name("login")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
			
	  }
	  @BeforeTest
	  @Parameters({"browser"})
	  public void LaunchBrowser(String browser) {
		  if (browser.equals("Chrome")) {
			  ChromeOptions options =new ChromeOptions();
			  options.setHeadless(false);
		   	String absolutPath= System.getProperty("user.dir");
			String filepath=absolutPath+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", filepath);
			driver= new ChromeDriver(options);
		  }
		  else {
			  String absolutPath= System.getProperty("user.dir");
				String filepath=absolutPath+"\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", filepath);
				driver= new FirefoxDriver();
		  }
		  
			driver.manage().window().maximize();		
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  }

	  @AfterTest
	  public void CloseBrowser() {
		  driver.quit();
	  }

}
