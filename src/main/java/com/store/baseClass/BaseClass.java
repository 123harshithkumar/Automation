package com.store.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.store.actionDriver.Action;
import com.store.utility.ExtentManager;

import org.apache.log4j.xml.DOMConfigurator;
public class BaseClass{

	//Action a=new Action();
	public static WebDriver driver;
	public static Properties prop;	

//	@BeforeSuite(groups= {"sanity","regression"})
//	public void beforeSuite() {
//		DOMConfigurator.configure("log4j.xml");
//	}
//	@BeforeTest(groups= {"sanity","regression"})
//	public void loadconfig() {
//		try {	
//			prop=new Properties();
//			FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
//			prop.load(f);	
//		}
//		catch(FileNotFoundException e) {
//			e.getStackTrace();
//		}catch(IOException e) {
//
//		}
//	}
	//loadConfig method is to load the configuration
		@BeforeSuite(groups = {"sanity", "regression" })
		public void loadConfig() {
			ExtentManager.setExtent();
			DOMConfigurator.configure("log4j.xml");

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public void launchApp(String browser) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//String browser=prop.getProperty("browser");
		if(browser.contains("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.contains("FireFox")) {
			driver=new FirefoxDriver();
		}else if(browser.contains("IE")) {
			driver=new InternetExplorerDriver();
		}else if(browser.contains("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	
		
	}
	@AfterSuite(groups = {"regression","sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
