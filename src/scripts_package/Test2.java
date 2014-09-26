package scripts_package;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import test_utils.Helper_class;


public class Test2 extends Helper_class {
	
 @Test
 public void a()  {
	 
	 System.out.println("\n ---- TEST CASE 2 VERIFYING IMAGES IN THE SLIDESHOW ---- \n");
	 System.out.println("----- CURRENT PAGE URL IS ----- \n" +driver.getCurrentUrl());
	 
	 	sleep(3);
		List<WebElement> img_list = driver.findElement(By.className("flex-viewport")).findElements(By.tagName("li"));
		List<WebElement> img_mod_list = new ArrayList<WebElement>();
		
		for(int i=0;i<img_list.size();i++){
			if(!(img_list.get(i).getAttribute("class").equals("clone"))){
				img_mod_list.add(img_list.get(i));
			}
		}
		System.out.println("TOTAL NUMBER OF IMAGES IN THE SLIDE SHOW ARE : " + img_mod_list.size());
		List<String> img = new ArrayList<String>();
		int c=0;
		for(int j=0;j<img_mod_list.size();j++){
			
			boolean a = img_mod_list.get(j).getAttribute("class").equals("flex-active-slide");
			if(a){
			 c =j;
			}
		}
	
			int k=0;
			for(int i=c;i<img_mod_list.size();i++){
				System.out.println("LOADING IMAGE " +i +":" +img_mod_list.get(i).getAttribute("class"));
				System.out.println("*IMAGE " +i +" VERIFIED");
				img.add(img_mod_list.get(i).getAttribute("class"));
				k = k+1;
			driver.findElement(By.className("flex-direction-nav")).findElement(By.className("flex-next")).click();
			sleep(1);
			}
		int cc = img_mod_list.size()-k;
		for(int l=0;l<cc;l++){
			System.out.println("LOADING IMAGE " +l +":" +img_mod_list.get(l).getAttribute("class"));
			System.out.println("*IMAGE " +l +" VERIFIED");
			img.add(img_mod_list.get(l).getAttribute("class"));
			driver.findElement(By.className("flex-direction-nav")).findElement(By.className("flex-next")).click();
			sleep(1);
		}
				
	if(img.size()==img_mod_list.size()){
		System.out.println("\n ALL IMAGES ARE LOADING PROPERLY");
	}else{
	
		Assert.fail("ERROR IN LOADING IMAGES");
	
	}
	System.out.println("\n----- NAVIGATING TO THE NEXT PAGE -----");
	  System.out.println("\n ---- TEST CASE 2 COMPLETED ----");
	
 }
 
 }

