package com.store.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.store.actionDriver.Action;
import com.store.baseClass.BaseClass;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;

public class ProductsPage extends BaseClass{

	@FindBy(xpath="//div[@class='app_logo']")
	WebElement applogo;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement Menu;
	
	@FindBy(xpath="//img[@alt='Sauce Labs Backpack']")
	WebElement image;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement title;
	
	@FindBy(xpath="//div[@class='inventory_item_desc']")
	WebElement description;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement price;
	
	@FindBy(xpath="//button[starts-with(@id,'add-to-cart-')]")
	WebElement addtoCart;
	
	public String checkPageTitle() {
		return Action.getTitle(driver);
	}
	public boolean checkLogo() {
		return Action.isDisplayed(driver, applogo);
	}
	public boolean checkMenu() {
		return Action.isDisplayed(driver, Menu);
	}
	public String getprodTitle(int in) {
		return driver.findElement(By.xpath("(//div[@class='inventory_item_name'])["+in+"]")).getText();
	}
	public String getprodDesc(int in) {
		return driver.findElement(By.xpath("(//div[@class='inventory_item_desc'])["+in+"]")).getText();
	}
	public String getprodPrice(int in) {
		return driver.findElement(By.xpath("(//div[@class='inventory_item_price'])["+in+"]")).getText();
	}
	public void clickAddToCart(int in) {
		driver.findElement(By.xpath("(//button[starts-with(@id,'add-to-cart-') or starts-with(@id,'remove-')])["+in+"]")).click();
	}
	public boolean checkImage(int in) {
		return driver.findElement(By.xpath("(//img[@class='inventory_item_img'])["+in+"]")).isDisplayed();
	}
	public String readFromExcel(int r,int c) throws Exception {
		FileInputStream fis = new FileInputStream(new File(".//src//main//resources//TestData.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        
        // Read data from a specific cell
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(c);
        String dataFromExcel="";
//        if(r==1 && c==0) {
//        	dataFromExcel=String.valueOf(cell.getNumericCellValue());
//        }else {
//        	dataFromExcel= cell.getStringCellValue();
//        }
        dataFromExcel= cell.getStringCellValue();
        return dataFromExcel;
       
}
	public void writeToExcel(int r,int c,String val) throws Exception {
		FileInputStream fis = new FileInputStream(new File(".//src//main//resources//TestData.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        
        // Write data to Excel
        Row newRow = sheet.getRow(r); 
        Cell newCell = newRow.getCell(c);
        newCell.setCellValue(val); // Set the cell value
        
        // Save changes to the Excel file
        FileOutputStream fos = new FileOutputStream(".//src//main//resources//TestData.xlsx");
        workbook.write(fos);
        fos.close();
	}
       
}
	


