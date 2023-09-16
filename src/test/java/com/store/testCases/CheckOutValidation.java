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
import com.store.pageObjects.CheckoutPage;
import com.store.pageObjects.LoginPage;
import com.store.pageObjects.MenuPage;
import com.store.pageObjects.ProductsPage;
import com.store.pageObjects.YourCartPage;

/**
 * 
 */
public class CheckOutValidation extends BaseClass {
	LoginPage l;
	ProductsPage p;
	MenuPage m;
	AddToCartPage a;
	YourCartPage y;
	CheckoutPage ch;
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
	@Test(priority=3)
	public void Product() throws Exception {
		p=new ProductsPage();

		Thread.sleep(4000);
		softassert=new SoftAssert();
		softassert.assertTrue(p.checkLogo(),"Page Logo is not displayed in products page");	
		String pagetitle=p.checkPageTitle();
		softassert.assertEquals(pagetitle, "Swag Labs","Page title is not matching");	
		softassert.assertTrue(p.checkMenu(),"Menu Icon is not Available in products page");	

		int n=driver.findElements(By.xpath("(//div[@class='inventory_item_name'])")).size();
		float price=0;
		int inputProd=Integer.parseInt(p.readFromExcel(1, 0));
		System.out.println(inputProd);
		String inputprodName="";
		for(int i=1;i<=inputProd;i++) {
			inputprodName=p.readFromExcel(i, 1);
			for(int j=1;j<=n;j++) {
				//System.out.println("inside"+inputprodName+" : "+p.getprodTitle(j));
				if(p.getprodTitle(j).equalsIgnoreCase(inputprodName)) {
					System.out.println("inside"+inputprodName+" : "+p.getprodTitle(j));
					System.out.println("Product Title is : "+p.getprodTitle(j));
					System.out.println("Product Desc is : "+p.getprodDesc(j));
					p.writeToExcel(i, 2, p.getprodDesc(j));
					System.out.println("Product Price is : "+p.getprodPrice(j));
					p.writeToExcel(i, 3, p.getprodPrice(j));


					price = price+ Float.parseFloat(p.getprodPrice(j).replace("$",""));

					softassert.assertTrue(p.checkImage(j),"Product Image is not displayed");
					p.clickAddToCart(j);
				}
			}
		}
		String formattedValue1 = String.format("%.2f", price);
		p.writeToExcel(1, 4, formattedValue1);
		System.out.println("Total Price is : "+formattedValue1);

		softassert.assertAll();
	}
	@Test(priority=4)
	public void AddToCart() throws Exception {
		a=new AddToCartPage();
		p=new ProductsPage();
		softassert=new SoftAssert();
		softassert.assertTrue(a.checkCartIcon(), "CartIcon not displayed");
		softassert.assertEquals(a.checkCartCount(), p.readFromExcel(1, 0),"Items count on cart Icon is not matching with expected count");
		a.clickCart();

		softassert.assertAll();
	}
	@Test(priority=5)
	public void YourCart() throws Exception {
		softassert=new SoftAssert();
		y=new YourCartPage();
		p=new ProductsPage();
		softassert.assertTrue(y.checkYourCartText(),"YourCart Text not displayed");
		softassert.assertTrue(y.checkDescLabel(),"Description label Text not displayed");
		softassert.assertTrue(y.checkQtyLabel(),"Quantity label Text not displayed");
		int n=driver.findElements(By.xpath("(//div[@class='inventory_item_name'])")).size();
		float price=0;
		int inputProd=Integer.parseInt(p.readFromExcel(1, 0));
		System.out.println(inputProd);
		String inputprodName="";
		for(int i=1;i<=inputProd;i++) {
			inputprodName=p.readFromExcel(i, 1);
			for(int j=1;j<=n;j++) {
				//System.out.println("inside"+inputprodName+" : "+p.getprodTitle(j));
				if(y.getTextTitle(j).equalsIgnoreCase(inputprodName)) {
					System.out.println("Product Title in YourCart PAGE is : "+y.getTextTitle(j));
					System.out.println("Product Price in YourCart PAGE is : "+y.getTextPrice(j));

					softassert.assertEquals(y.getTextTitle(j),p.readFromExcel(i, 1), "Product title in YourCart PAGE is incorrect");
					softassert.assertEquals(y.getTextPrice(j),p.readFromExcel(i, 3), "Product Price in YourCart PAGE is incorrect");
					softassert.assertEquals(y.getTextQtity(j),"1", "Product Quantity in YourCart PAGE is incorrect");
					softassert.assertTrue(y.checkRemoveProd(j), "Remove button is not enabled");
				}
			}
		}
		
		y.clikCheckOut();

		softassert.assertAll();
	}
	@Test(priority=6)
	public void checkout() throws Exception {
		softassert=new SoftAssert();
		ch=new CheckoutPage();
		p=new ProductsPage();
		ch.checkoutInfo("Ramesh", "Rajesh", "Koramangala,Bangalore 876543");
		ch.clickContinue();
		
		softassert.assertTrue(ch.overviewText(),"Overview Text not displayed");
		softassert.assertTrue(ch.checkDescLabel(),"Description label Text not displayed");
		softassert.assertTrue(ch.checkQtyLabel(),"Quantity label Text not displayed");
		int n=driver.findElements(By.xpath("(//div[@class='inventory_item_name'])")).size();
		float price=0;
		int inputProd=Integer.parseInt(p.readFromExcel(1, 0));
		System.out.println(inputProd);
		String inputprodName="";
		for(int i=1;i<=inputProd;i++) {
			inputprodName=p.readFromExcel(i, 1);
			for(int j=1;j<=n;j++) {
				//System.out.println("inside"+inputprodName+" : "+p.getprodTitle(j));
				if(y.getTextTitle(j).equalsIgnoreCase(inputprodName)) {
					System.out.println("Product Title in CheckOut Overview PAGE is : "+ch.getTextTitle(j));
					System.out.println("Product Price in CheckOut Overview PAGE is : "+ch.getTextPrice(j));

					softassert.assertEquals(ch.getTextTitle(j),p.readFromExcel(i, 1), "Product title in CheckOut Overview PAGE is incorrect");
					softassert.assertEquals(ch.getTextPrice(j),p.readFromExcel(i, 3), "Product Price in CheckOut Overview PAGE is incorrect");
					softassert.assertEquals(ch.getTextQtity(j),"1", "Product Quantity in CheckOut Overview PAGE is incorrect");
					//softassert.assertTrue(ch.checkRemoveProd(j), "Remove button is not enabled");
				}
			}
		}
		softassert.assertEquals(ch.PaymentInfo(),"Payment Information", "Checkout Oveview- Payment Info text is incorrect");
		softassert.assertTrue(ch.PaymentValue(), "Checkout Oveview- Payment Value is not disaplyed");
		softassert.assertEquals(ch.ShipInfo(),"Shipping Information", "Checkout Oveview- Shipment Info text is incorrect");
		softassert.assertEquals(ch.ShipValue(),"Free Pony Express Delivery!", "Checkout Oveview- Shipment Value text is incorrect");
		softassert.assertEquals(ch.TotalInfo(),"Price Total", "Checkout Oveview- Total Price text is incorrect");
		String totalPriceValue=ch.TotalValue();
		softassert.assertTrue(totalPriceValue.contains("Item total: $"), "Checkout Oveview- Total Price Text is not disaplyed");
		softassert.assertTrue(totalPriceValue.contains(p.readFromExcel(1, 4)), "Checkout Oveview- Total price is incorrect");

		ch.clikCheckOutFinish();
		
		softassert.assertAll();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
