package scripts_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import test_utils.Helper_class;

public class Test3 extends Helper_class {
  
	@Test
  
	public void f() {
	  
		System.out.println("\n ---- TEST CASE 3 SELECTING RANDOM ITEM ---- \n");
		System.out.println("---- SELECTING MEN FROM HEADER ----");
		System.out.println("----- CURRENT PAGE URL IS -----\n" +driver.getCurrentUrl());
		
		
		List<WebElement> head = driver.findElement(By.cssSelector("div.navbar")).findElements(By.tagName("a"));
		Actions y = new Actions(driver);
		y.moveToElement(head.get(1)).build().perform();
	  
	  List<WebElement> select = driver.findElement(By.cssSelector("div.pane.fashion.show")).findElements(By.tagName("a"));
	  System.out.println("TOTAL NUMBER OF ITEMS IN THE BANNER ARE : " +select.size());
	 
	  System.out.println("RANDOM ITEM SELECTED FROM THE BANNER IS : " +select.get(3).getText());
	  select.get(3).click();
	  
	  List<WebElement> sale1 = new ArrayList<WebElement>();
	  sale1 = driver.findElement(By.cssSelector("ul.results.small")).findElements(By.tagName("li"));
	  System.out.println("TOTAL NUMBER OF ITEMS UNDER THE SELECTED SECTION ARE : " +sale1.size());
	  
	  Random r = new Random();
	  int b = r.nextInt(sale1.size());
	  
	  System.out.println("RANDOM ITEM SELECTED IS : " + b + "\n ----- SELECTED ITEM DETAILS ARE ----- \n" + sale1.get(b).getText());
	  
	  sale1.get(b).click();
	  
	  System.out.println("\n----- NAVIGATING TO THE NEXT PAGE -----");
	  
	  System.out.println("----- CURRENT PAGE TITLE IS -----\n" +driver.getTitle());
	  
	  waitforelement(10, By.cssSelector("div.buy"));
	  
	  driver.findElement(By.cssSelector("div.buy")).click();
	  
	  waitforelement(20,By.cssSelector("div.sizes"));
	  
	  List<WebElement> sizesel = new ArrayList<WebElement>();
	  
	  sizesel = driver.findElement(By.cssSelector("div.sizes")).findElements(By.cssSelector("button.size.pdp-size-btn.available"));
	  
	  System.out.println("\nTHE NUMBER OF AVAILABLE SIZES ARE : " + sizesel.size());
	  
	  Random r1 = new Random();
	  
	  int c = r1.nextInt(sizesel.size());
	  
	  System.out.println("RANDOM SIZE SELECTED IS :" + sizesel.get(c).getText());
	  
	  sizesel.get(c).click();
	  
	  String price = driver.findElement(By.cssSelector("div.price")).getText();
	  
	  System.out.println("CART GRAND TOTAL IS : "+price);
	  
	  waitforelement(20, By.cssSelector("div.place-order"));	  
	  driver.findElement(By.cssSelector(".btn.primary-btn.btn-continue")).click();
	  
	  System.out.println("\n----- NAVIGATING TO THE NEXT PAGE -----");
	  System.out.println("\n ---- TEST CASE 3 COMPLETED ----");	    
  }
}
