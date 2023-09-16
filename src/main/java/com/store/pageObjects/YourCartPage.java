package com.store.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

public class YourCartPage extends BaseClass{

	@FindBy(xpath="//span[@class='title']")
	WebElement yourCart;
	
	@FindBy(xpath="//div[@class='cart_quantity_label']")
	WebElement qtyLabel;
	
	@FindBy(xpath="//div[@class='cart_desc_label']")
	WebElement qtyDesc;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement prodTitle;
	
	@FindBy(xpath="//div[@class='cart_quantity']")
	WebElement prodQtity;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement prodPrice;
	
	@FindBy(xpath="//button[starts-with(@id,'remove-')]")
	WebElement prodRemove;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement prodCheckout;
	
	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean checkYourCartText() {
		return Action.isDisplayed(driver, yourCart);
	}
	
	public boolean checkQtyLabel() {
		return Action.isDisplayed(driver, qtyLabel);
	}
	public boolean checkDescLabel() {
		return Action.isDisplayed(driver, qtyDesc);
	}
	public String getTextQtity(int in) {
		return driver.findElement(By.xpath("(//div[@class='cart_quantity'])["+in+"]")).getText();
	}
	public String getTextTitle(int in) {
		return driver.findElement(By.xpath("(//div[@class='inventory_item_name'])["+in+"]")).getText();
	}
	public String getTextPrice(int in) {
		return driver.findElement(By.xpath("(//div[@class='inventory_item_price'])["+in+"]")).getText();
	}
	public boolean checkRemoveProd(int in) {
		return driver.findElement(By.xpath("(//button[starts-with(@id,'remove-')])["+in+"]")).isEnabled();
	}
	public void clikCheckOut() {
		Action.click(driver, prodCheckout);
	}

}	
