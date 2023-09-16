package com.store.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath="//input[@id='user-name']")
	WebElement usname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement logo;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkPageTitle() {
		return Action.getTitle(driver);
	}
	public boolean checkLogo() {
		return Action.isDisplayed(driver, logo);
	}
	public void Login(String uname,String pass) {
		Action.type(usname, uname);
		Action.type(password, pass);
		Action.click(driver, loginbutton);
	}
	
}
