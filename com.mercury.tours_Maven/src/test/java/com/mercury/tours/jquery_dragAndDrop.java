package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class jquery_dragAndDrop {
	ChromeDriver driver;
  @Test 
  public void Sign_On_ValidCred() throws InterruptedException {
	  WebElement element_from=driver.findElementById("draggable");
	  WebElement element_to=driver.findElementById("droppable");
	  Actions action = new Actions(driver);
	  action.dragAndDrop(element_from, element_to).build().perform();
	  Thread.sleep(1000);
  }
  @BeforeTest
  public void LaunchBrowser() {
	  	ChromeOptions options =new ChromeOptions();
	  	options.setHeadless(false);
	  	//options.addArguments("incognito");
	  	String absolutPath= System.getProperty("user.dir");
		String filepath=absolutPath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");		
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
