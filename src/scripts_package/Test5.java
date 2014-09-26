package scripts_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import test_utils.Helper_class;

public class Test5 extends Helper_class {
  @Test
  public void f() {
	  
	  System.out.println("\n ---- TEST CASE 5 GETTING CART DETAILS ---- \n");
	  System.out.println(" ----- CURRENT PAGE URL IS -----\n" +driver.getCurrentUrl());
	  Actions x = new Actions(driver);
	  x.moveToElement(driver.findElement(By.cssSelector("a.cart"))).build().perform();
	
	  sleep(3);
	  WebElement a = driver.findElement(By.cssSelector("div.flyout.bag")).findElement(By.cssSelector("div.col60"));
	  String strr = a.getText();
	  System.out.println("TOTAL NUMBER OF ITEMS IN THE CART ARE : " +strr);	  
	  
	  List<WebElement> abcd = driver.findElement(By.cssSelector("div.flyout.bag")).findElement(By.cssSelector("div.col40.r")).findElements(By.tagName("div"));
	  System.out.println("TOTAL PRICE IN THE CART BEFORE DISCOUNT IS : " +abcd.get(0).getText());
	  System.out.println("TOTAL PRICE IN THE CART AFTER DISCOUNT IS  : " +abcd.get(1).getText());
	  
	  System.out.println("\n ---- TEST CASE 5 COMPLETED ----");
  }
}
