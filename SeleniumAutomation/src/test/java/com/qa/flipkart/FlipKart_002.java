package com.qa.flipkart;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FlipKart_002  extends TestBaseFlipKart {
	
	
	
		
		
		@Test
		public void LoginFailed() {
			
			Fp.getEmail().sendKeys("reddyarchana753@gmail.com");
			Fp.getEmail().submit();
			Fp.getPassword().sendKeys("archana");
			Fp.getPassword().submit();
			//Fp.getLoginBtn().click();
			String ErrorMsg1 = Fp.getErrorMsg().getText();
			Assert.assertEquals(ErrorMsg1, "Your username or password is incorrect");
					
			Reporter.log("Error message displayed",true);
		}
			
				

		
		
		

		
		
	
	
	
	
	
	}


