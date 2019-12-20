package com.mercury.tours;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

public class Screenshot_with_TestNG_priority {
	ChromeDriver driver;
  @Test (priority=1)
  public void Sign_On() throws InterruptedException {
	  	driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("dixit");
		driver.findElement(By.name("password")).sendKeys("dixit");
		driver.findElement(By.name("login")).click();
				
  }
  @Test
  public void LaunchBrowser() {
	  ChromeOptions options =new ChromeOptions();
	  	options.setHeadless(false);
	  	String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }
  
  @Test (priority=4)
  public void sign_off() throws Exception {
	  driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFoF')]")).click();
  }
  
  @AfterMethod
  public void Screenshot(ITestResult result) throws IOException{
	if(ITestResult.FAILURE==result.getStatus())
	{
		File Browserscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browserscreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\SignOff.png"));
		FileUtils.copyFile(Browserscreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+"_"+System.nanoTime()+".png"));

	}
  }
  
  @Test (priority=4)
  public void z_CloseBrowser() {
	  driver.quit();
  }
  
  @Test (priority=2)
  public void entering_data() {
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
		driver.findElement(By.name("findFlight1s")).click();
  }
  
}
