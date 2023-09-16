package com.store.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

public class FilterPage extends BaseClass {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filter;
	
	public boolean checkFilter() {
		return Action.isDisplayed(driver, filter);
	}
	public boolean checkOptions(int in) {
		return driver.findElement(By.xpath("//select[@class='product_sort_container']/option["+in+"]")).isDisplayed();
	}
	public void selectOption(String option) {
		Action.selectByVisibleText(option, filter);
	}
}
