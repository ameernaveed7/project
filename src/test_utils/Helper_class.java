package test_utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import main_package.Test_Base;

public class Helper_class extends Test_Base {
	
						//-----SCREEN SHOT METHOD-----//
	
	public void takescreenshot (String Filename) throws IOException{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("user.dir"+configuration.getProperty("screenShotsPath")+"\\"+Filename+".jpg"));  
		}
	
						//------SLEEP METHOD------//
	
	public void sleep(int seconds){
		try{
			Thread.sleep(seconds*1000);
		}
		catch(Exception e){
		}
	}

						//----- WAIT FOR ELEMENT METHOD-----//
	public boolean waitforelement(int timeout,By by){
		while(timeout>0){
			sleep(1);
			List<WebElement> list = driver.findElements(by);
			if(list.size()!=0){
				return true;
			}
			timeout--;
		}
		System.out.println("waiting timeout.... Element not found " +by.toString());
		return false;
	}
	
						//-----LOGIN INFORMATION-----//
	
	public static void login(String email, String password) throws InterruptedException{
		
		
		if (driver.findElements(By.tagName("a.class.login")).size()==0){
		
			System.out.println("**USER IS NOT CURRENTLY LOGEDIN**");
			System.out.println(String.format("LOGIN INFORMATION GIVEN IS : \n USER NAME : %s \n PASSWORD  : %s FROM CONFIGURATION FILE",email,password));
			System.out.println("ATTEMPTING LOGIN PLEASE WAIT.........");
			driver.findElement(By.cssSelector("a.login")).click();
			driver.findElement(By.cssSelector("form[name=\"signin\"] > div.email > input[name=\"email\"]")).sendKeys(email);
			driver.findElement(By.cssSelector("div.signin > div.password > input[name=\"password\"]")).sendKeys(password);
			driver.findElement(By.cssSelector("div.signin > button.button.fill")).click();

		if (driver.findElements(By.cssSelector("a.user")).size() > 0){	
		
			System.out.println("----LOGIN SUCCESSFUL----");
			
			return;
			
		}
			return;
		}
		
		else{
			
		Assert.fail("login failed");;
		
		}
	}
}


