package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Flight_login_firefox {
	FirefoxDriver driver;
  @Test
  public void Sign_On() throws InterruptedException {
	  	driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("dixit");
		driver.findElement(By.name("password")).sendKeys("dixit");
		driver.findElement(By.name("login")).click();
		Thread.sleep(20000);
		WebElement element= driver.findElement(By.linkText("SIGN-OFF"));
		String actvalue=element.getText();
		Assert.assertEquals(actvalue,"SIGN-OFF");
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		driver.findElement(By.cssSelector("input[value='Business']")).click();
		Select select_Returning_month= new Select(driver.findElement(By.name("toMonth")));
		select_Returning_month.selectByValue("2");		
		Select select_Returning_day= new Select(driver.findElement(By.name("toDay")));
		select_Returning_day.selectByValue("27");
		Select select_Airline= new Select(driver.findElement(By.name("airline")));
		select_Airline.selectByVisibleText("Blue Skies Airlines");
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
		
  }
  @BeforeTest
  public void LaunchBrowser() {
	   	String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filepath);
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
