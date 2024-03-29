package com.mercury.tours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class before_after_test {
	ChromeDriver driver;

	@Test
	public void Sign_On_ValidCred()
	{
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("dixit");
		driver.findElement(By.name("password")).sendKeys("dixit");
		driver.findElement(By.name("login")).click();		
	}
	
	@Before
	public void LaunchBrowser()
	{
		String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		//System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
	
	@After
	public void CloseBrowser()
	{
		driver.quit();	
	}
}