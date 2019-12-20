package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Mercury_Sign_On_Properties {
	ChromeDriver driver;
  @Test 
  public void Sign_On_ValidCred() throws IOException {
	  File file=new File("D:\\Selenium training\\com.mercury.tours_Maven\\Mercury_tours.properties");
	  Properties prop =  new Properties();
	  FileInputStream fileinput= new FileInputStream(file);
	  prop.load(fileinput);
	  	driver.findElement(By.linkText(prop.getProperty("Ssignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Iuserpass"))).sendKeys("testing");
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
