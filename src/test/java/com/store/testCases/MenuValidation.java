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
import com.store.pageObjects.YourCartPage;

/**
 * 
 */
public class MenuValidation extends BaseClass {
	LoginPage l;
	ProductsPage p;
	MenuPage m;
	AddToCartPage a;
	YourCartPage y;
	SoftAssert softassert;
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws Exception {
		launchApp(browser);
	}


	@Test(priority=1)
	public void login() {
		l=new LoginPage();
		softassert=new SoftAssert();
		String pagetitle=l.checkPageTitle();
		softassert.assertEquals(pagetitle, "Swag Labs","Page title is not matching");	
		softassert.assertTrue(l.checkLogo(),"Page Logo is not displayed");	
		l.Login(prop.getProperty("username"), prop.getProperty("password"));
		softassert.assertAll();

	}
	@Test(priority=2)
	public void Menu() throws Exception  {
		softassert=new SoftAssert();
		m=new MenuPage();
		m.clickMenu();
		Thread.sleep(2000);
		softassert.assertEquals(m.allItemText(), "All Items","All itema Text not matching in Menu popup");
		softassert.assertEquals(m.aboutText(), "About","About Text not matching in Menu popup");
		softassert.assertEquals(m.resetText(), "Reset App State","Reset App store Text not matching in Menu popup");
		softassert.assertEquals(m.logoutText(), "Logout","Logout Text not matching in Menu popup");
		Thread.sleep(2000);
		m.closeMenu();
		m.closeMenu();
		softassert.assertAll();

	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
