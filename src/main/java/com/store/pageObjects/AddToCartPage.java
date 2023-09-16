package com.store.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(xpath="//*[@class='shopping_cart_link']")
	WebElement cartIcon;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartCount;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddToCart(int in) {
		driver.findElement(By.xpath("(//button[starts-with(@id,'add-to-cart-')])["+in+"]")).click();
	}
	
	public boolean checkCartIcon() {
		return Action.isDisplayed(driver, cartIcon);
	}
	
	public String checkCartCount() {
		return Action.getText(driver, cartCount);
	}
	public void clickCart() {
		Action.click(driver, cartIcon);
	}
}
