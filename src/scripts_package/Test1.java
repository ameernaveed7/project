package scripts_package;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_utils.Helper_class;


public class Test1 extends Helper_class {
	
	@Test
	 public void f1() throws Exception{
		  
		Helper_class h = new Helper_class();
		driver.get(configuration.getProperty("testUrl"));
		System.out.println("GIVEN URL FROM THE PROPERTIES FILE IS : " + configuration.getProperty("testUrl"));		
		System.out.println("\n ---- TEST CASE 1 LOGIN PAGE ---- \n");
		System.out.println("----- CURRENT URL IS ----- \n" +driver.getCurrentUrl());
		h.login(configuration.getProperty("email"), configuration.getProperty("password"));
		System.out.println("\n ---- TEST CASE 1 COMPLETED ----");
	 }
	 
	@BeforeMethod
	  public void beforeMethod() {

		 if (configuration.getProperty("browserType").equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
			 
		 }else if (configuration.getProperty("browserType").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\executable_files_drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		 }else if(configuration.getProperty("browserType").equalsIgnoreCase("IE")) {
			 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\src\\executable_files_drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			 
		 }else{
			 driver = new SafariDriver();
		 }
	  }
}
