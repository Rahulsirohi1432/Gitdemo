package com.automation.Config;

import static com.automation.ExecutionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {
	public static WebDriver driver;
	
	public static void OpenBrowser(String object) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver2.exe");
		driver = new ChromeDriver();
		
	}
	
	public static void Navigate(String object)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		
	}
	
	public static void Input_Username(String object)
	{
		driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.UserName);
		
	}
	
	public static void Input_Password(String object)
	{
		driver.findElement(By.xpath("//input[@id='j_password_view']")).sendKeys(Constants.Password);
	}
   
	public static void Click(String object)
	{
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	 public static void Waitfor(String object) throws InterruptedException
	 {
		 Thread.sleep(5000);
	 }
	 
//	 public static void Click() 
//	 {
//		 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
//	 }
	 public static void CloseBrowser(String object)
	 {
		 driver.quit();
	 }
}
