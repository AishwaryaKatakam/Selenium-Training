package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class hdfc {
	ChromeDriver driver;
  @Test 
  public void Sign_On_ValidCred() throws InterruptedException {
	  	//driver.findElement(By.cssSelector("input[class='input_password']")).sendKeys("test");
		driver.findElement(By.xpath("//img[@alt='continue']")).click();	
		Assert.assertEquals(driver.switchTo().alert().getText(),"Customer ID  cannot be left blank.");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  	ChromeOptions options =new ChromeOptions();
	  	options.setHeadless(true);
	  	//options.addArguments("incognito");
	  	String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
