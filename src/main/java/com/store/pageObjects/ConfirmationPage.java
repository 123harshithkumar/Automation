package com.store.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;
public class ConfirmationPage extends BaseClass{
	
	@FindBy(xpath="//span[@class='title']")
	WebElement checkOutConfirmTitle;
	
	@FindBy(xpath="//img[@alt='Pony Express']")
	WebElement confirmImage;
	
	@FindBy(xpath="//*[@class='complete-header']")
	WebElement ConfirmThank;
	
	@FindBy(xpath="//div[@class='complete-text']")
	WebElement confirmMessage;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement backToHome;
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkConfirmTitle() {
		return Action.getText(driver, checkOutConfirmTitle);
	}
	public boolean checkConfirmimage() {
		return Action.isDisplayed(driver, confirmImage);
	}
	public String checkConfirmThank() {
		return Action.getText(driver, ConfirmThank);
	}
	public String checkConfirmMessage() {
		return Action.getText(driver, confirmMessage);
	}
	public String checkBackToHome() {
		return Action.getText(driver, backToHome);
	}
	public void backClick() {
		Action.click(driver, backToHome);
	}

}
