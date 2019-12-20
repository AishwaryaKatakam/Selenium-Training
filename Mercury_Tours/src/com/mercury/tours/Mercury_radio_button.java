package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Mercury_radio_button {
	ChromeDriver driver;
  @Test 
  public void Sign_On_ValidCred() throws InterruptedException {
	  	driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();		
		Assert.assertEquals(driver.getCurrentUrl(),"http://newtours.demoaut.com/mercuryreservation.php");
		Assert.assertEquals(driver.getTitle(),"Find a Flight: Mercury Tours:");
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
