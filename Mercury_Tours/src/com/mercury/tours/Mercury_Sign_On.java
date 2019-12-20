package com.mercury.tours;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercury_Sign_On {

	@Test
	public void Sign_On_ValidCred()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium training\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");	
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("dixit");
		driver.findElement(By.name("password")).sendKeys("dixit");
		driver.findElement(By.name("login")).click();
		driver.close();
	}
}
