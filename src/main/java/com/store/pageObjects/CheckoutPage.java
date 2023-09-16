package com.store.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;
public class CheckoutPage extends BaseClass{
	
	@FindBy(xpath="//span[@class='title']")
	WebElement checkOutTitle;
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement address;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement cancel;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement checkContinue;
	
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
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement checkoutFinish;
	
	@FindBy(xpath="(//div[@class='summary_info_label'])[1]")
	WebElement paymentInfo;
	
	@FindBy(xpath="(//div[@class='summary_value_label'])[1]")
	WebElement paymentInfoval;
	
	@FindBy(xpath="(//div[@class='summary_info_label'])[2]")
	WebElement summaryInfo;
	
	@FindBy(xpath="(//div[@class='summary_value_label'])[2]")
	WebElement summaryInfoval;
	
	@FindBy(xpath="(//div[@class='summary_info_label'])[3]")
	WebElement totalInfo;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	WebElement totalPrice;
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutInfo(String fname1,String lname1,String address1) {
		Action.type(fname, fname1);
		Action.type(lname, lname1);
		Action.type(address, address1);
	}
	public void clickContinue() {
		Action.click(driver, checkContinue);
	}
	public boolean overviewText() {
		return Action.isDisplayed(driver, checkOutTitle);
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
//	public boolean checkRemoveProd(int in) {
//		return driver.findElement(By.xpath("(//button[starts-with(@id,'remove-')])["+in+"]")).isEnabled();
//	}
	
	public String PaymentInfo() {
		return Action.getText(driver, paymentInfo);
	}
	public boolean PaymentValue() {
		return Action.isDisplayed(driver, paymentInfoval);
	}
	public String ShipInfo() {
		return Action.getText(driver, summaryInfo);
	}
	public String ShipValue() {
		return Action.getText(driver, summaryInfoval);
	}
	public String TotalInfo() {
		return Action.getText(driver, totalInfo);
	}
	public String TotalValue() {
		return Action.getText(driver, totalPrice);
	}
	
	public void clikCheckOutFinish() {
		Action.click(driver, checkoutFinish);
	}


}
