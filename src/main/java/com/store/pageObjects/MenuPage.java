package com.store.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

public class MenuPage extends BaseClass{

	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement applogo;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement Menu;
	
	@FindBy(xpath="//img[@alt='Sauce Labs Backpack']")
	WebElement image;
	
	@FindBy(xpath="//*[@id='inventory_sidebar_link']")
	WebElement allItem;
	
	@FindBy(xpath="//*[@id='about_sidebar_link']")
	WebElement about;
	
	@FindBy(xpath="//*[@id='logout_sidebar_link']")
	WebElement logout;

	@FindBy(xpath="//*[@id='reset_sidebar_link']")
	WebElement resetStore;

	@FindBy(xpath="//button[@id='react-burger-cross-btn']")
	WebElement closeMenu;
	
	public MenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkPageTitle() {
		return Action.getTitle(driver);
	}
	public boolean checkLogo() {
		return Action.isDisplayed(driver, applogo);
	}
	public boolean checkMenu() {
		return Action.isDisplayed(driver, Menu);
	}
	public void clickMenu() {
		Action.click(driver, Menu);
		System.out.println("menu click");

	}
	public String allItemText() {
		return Action.getText(driver, allItem);
	}
	public String aboutText() {
		return Action.getText(driver, about);
	}
	public String logoutText() {
		return Action.getText(driver, logout);
	}
	public String resetText() {
		return Action.getText(driver, resetStore);
	}
	public boolean checkCloseMenu() {
		return Action.isDisplayed(driver, closeMenu);
	}
	public void closeMenu() {
		//Action.click(driver, closeMenu);
		Action.click(driver, closeMenu);
	}
}
