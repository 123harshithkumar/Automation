/**
 * 
 */
package com.store.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.baseClass.BaseClass;
import com.store.pageObjects.AddToCartPage;
import com.store.pageObjects.LoginPage;
import com.store.pageObjects.MenuPage;
import com.store.pageObjects.ProductsPage;

/**
 * 
 */
public class LoginValidation extends BaseClass {
	LoginPage l;
	ProductsPage p;
	MenuPage m;
	AddToCartPage a;
	SoftAssert softassert=new SoftAssert();
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}

	@Test(priority=1)
	public void login() {
		l=new LoginPage();
		String pagetitle=l.checkPageTitle();
		softassert.assertEquals(pagetitle, "Swag Labs","Page title is not matching");	
		softassert.assertTrue(l.checkLogo(),"Page Logo is not displayed");	
		l.Login(prop.getProperty("username"), prop.getProperty("password"));

	}


	@AfterClass
	public void close() {
		driver.quit();
	}
}
