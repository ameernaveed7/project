package scripts_package;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import test_utils.Helper_class;

public class Test4 extends Helper_class {
  @Test
  public void f() {
	  System.out.println("\n ---- TEST CASE 4 PASSING ADDRESS DETAILS ----");
	  System.out.println("----- CURRENT PAGE URL IS -----\n" +driver.getCurrentUrl());
	  if(driver.findElement(By.cssSelector("div.address-list-wrap")).isDisplayed()){
					
		  				//---clear given address data---//
		   
		System.out.println(" ** address already given ** \n ## clearing the previous address... ##");
		driver.findElement(By.cssSelector("span.delete-item")).click();
		sleep(5);
		System.out.println("---- ENTERING THE NEW USER DETAILS FROM CONFIGURATION FILE ----");
	  
	  }
	  else{
		  System.out.println("---- ENTERING THE USER DETAILS ----");
	  }
	  
	  sleep(7);
	  waitforelement(20, By.cssSelector("input.name"));
	  driver.findElement(By.cssSelector("input.name")).sendKeys(configuration.getProperty("name"));
	  System.out.println("NAME :" + configuration.getProperty("name") );
	  
	  waitforelement(10, By.cssSelector("input.pincode"));
	  driver.findElement(By.cssSelector("input.pincode")).sendKeys(configuration.getProperty("pin"));
	  System.out.println("PIN :" + configuration.getProperty("pin") );
	  
	  waitforelement(10, By.cssSelector("textarea.address"));
	  driver.findElement(By.cssSelector("textarea.address")).sendKeys(configuration.getProperty("address"));
	  System.out.println("HOME ADDRESS :" + configuration.getProperty("address") );
	  
	  waitforelement(10, By.cssSelector("input.locality.ui-autocomplete-input"));
	  driver.findElement(By.cssSelector("input.locality.ui-autocomplete-input")).sendKeys(configuration.getProperty("locality"));
	  System.out.println("LOCALITY :" + configuration.getProperty("locality") );
	  
	  waitforelement(10, By.cssSelector("input.mobile"));
	  driver.findElement(By.cssSelector("input.mobile")).sendKeys(configuration.getProperty("mobile"));
	  System.out.println("MOBILE NUMBER :" + configuration.getProperty("mobile") );
	  
	  System.out.println("----- ALL THE ADDRESS DETAILS ARE ENTERED PROPERLY ----- \n");
	  
	  System.out.println("----- NAVIGATING TO THE NEXT PAGE -----");
	  waitforelement(10, By.cssSelector("div.addressListContainer"));
	  driver.findElement(By.cssSelector("div.addressListContainer")).click();	  
	  System.out.println("----- CURRENT PAGE TITLE IS -----\n" +driver.getTitle());
	  
	  System.out.println("\n ---- TEST CASE 4 COMPLETED ----");
	  
	  waitforelement(10, By.cssSelector("a.logo"));
	  driver.findElement(By.cssSelector("a.logo")).click();	  

  }
}

