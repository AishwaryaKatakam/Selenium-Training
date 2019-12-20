package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Mercury_Sign_On_TestNG_Class {
	ChromeDriver driver;
  @Test 
  public void Sign_On_ValidCred() {
	  	driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://newtours.demoaut.com/mercuryreservation.php");
		/*String actual=driver.getCurrentUrl();		
		String expected="http://newtours.demoaut.com/mercuryreservation.php";		
		Assert.assertEquals(actual,expected); */
		Assert.assertEquals(driver.getTitle(),"Find a Flight: Mercury Tours:");
		WebElement element= driver.findElement(By.linkText("SIGN-OFF"));
		String actvalue=element.getText();
		Assert.assertEquals(actvalue,"SIGN-OFF");
  }
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
