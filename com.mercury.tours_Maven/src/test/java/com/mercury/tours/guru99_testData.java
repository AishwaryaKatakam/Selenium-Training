package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class guru99_testData extends application_testData{
	ChromeDriver driver;
  @Test (dataProvider="Sign_On")
  public void Sign_On(String uname,String pwd) throws InterruptedException {	  	
		driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		driver.switchTo().alert().accept();
		
  }
  @BeforeTest
  public void LaunchBrowser() throws InterruptedException {
	  ChromeOptions options =new ChromeOptions();
	  	options.setHeadless(false);
	  	String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.get("https://demo.guru99.com/V4/");
		Thread.sleep(8000);
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
