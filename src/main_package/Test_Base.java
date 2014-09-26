package main_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class Test_Base {
	public static Properties configuration = null;
	public static Properties OR = null;
	//public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public static WebDriver driver;

	@BeforeSuite
	public void initialize() throws IOException {
		
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\config_files\\configuration.properties");
		configuration = new Properties();
		configuration.load(fp);
		
		FileInputStream fp1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\config_files\\OR.properties");
		OR = new Properties();
		OR.load(fp1);
		
		System.out.println("BROWSER SELECTED FROM CONFIGURATION FILE IS : " + configuration.getProperty("browserType"));
		
		}
}
