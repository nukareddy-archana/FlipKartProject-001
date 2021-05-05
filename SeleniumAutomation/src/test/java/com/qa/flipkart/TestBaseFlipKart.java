package com.qa.flipkart;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBaseFlipKart {
	WebDriver driver;
	FlipKartPages Fp;
	
	
	@BeforeClass
	public void setup()
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Desktop\\eclipse\\chromedriver.exe");
		driver=new ChromeDriver();
		
	  driver.get("https://www.flipkart.com/");
	
	        
            Fp=new FlipKartPages(driver);  
            driver.manage().window().maximize();
	
	
	
	}

	 @AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		

	
	

}
