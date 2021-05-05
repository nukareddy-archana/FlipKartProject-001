package com.qa.flipkart;



import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.amazon.utility.testscripts.ExcelUtility;

public class Flipkart_001 extends TestBaseFlipKart {
	
	@DataProvider
	 public String[][] getData1() throws IOException{
		 
		 String xlPath = "C:\\Users\\LENOVO\\Desktop\\eclipse\\SeleniumAutomation\\src\\test\\java\\com\\qa\\TestData\\New Microsoft Excel Worksheet.xlsx";
		 String xlSheet = "Sheet1";
		 
		 int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
		 int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		 
		 String[][] data = new String[rowCount][cellCount];
		 
		 for(int i=1; i<=rowCount; i++) {
			 for(int j=0; j<cellCount;j++) {
				 data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			 }
		 }
		return data;
	 }
	
		@Test(dataProvider="getData1")
	public void Login(String UserName, String Password, String SearchForProduct ) throws InterruptedException {
		
			
			Fp.getEmail().sendKeys(UserName);
			Fp.getEmail().submit();
			Fp.getPassword().sendKeys(Password);
			Fp.getPassword().submit();
			
			Thread.sleep(1000);
			
			
			Fp.getSearchForProduct().sendKeys(SearchForProduct);
		    Fp.getSearchForProduct().submit();
		    Thread.sleep(5000);
		    boolean title=driver.getTitle().contains("Choclates");
		    Assert.assertTrue(title);
		   Reporter.log("user is searching for choclates",true);
		    Thread.sleep(1000);
			
		    
		    Fp.getClickOnProduct().click();
		    Thread.sleep(3000);
		    
		    
		    String parent=driver.getWindowHandle();
		    Set<String>s=driver.getWindowHandles();
		    Iterator<String> I1= s.iterator();
		    while(I1.hasNext())
		    {

		    String child_window=I1.next();


		    if(!parent.equals(child_window))
		    {
		    driver.switchTo().window(child_window);
			Fp.getBuyNowBtn().click();
		    }
		    }
		    Thread.sleep(3000);
		    String title1 = driver.getTitle();
			Assert.assertEquals(title1, "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
			Reporter.log("order placed successfully",true);
		    driver.navigate().back();
		    String xp="//div[contains(text(),'Archana')]";
		    WebElement MyAccount=driver.findElement(By.xpath(xp));
		    Actions action=new Actions(driver);
		    action.moveToElement(MyAccount).perform();
		   
		    Fp.Logout().click();
		    Thread.sleep(3000);
		    
		   
		    
			 boolean title2=driver.getTitle().contains("Online Shopping Site for Mobiles");
			  Assert.assertTrue(title2);
			   Reporter.log("logged out",true);
		 
		  
		   
		   
		   
		   
		   
		   
		   
		}


			

}
