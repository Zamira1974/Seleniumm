package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
/*
TC 1: Delete Employee
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
Login into the application
Add Employee
Verify Employee has been added
Go to Employee List
Delete added Employee
Quit the browser
 * */
public class HomeWork1 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).submit();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Employee']")));
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Zara");
		
		driver.findElement(By.name("lastName")).sendKeys("Zaraza");
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).submit();
		
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		
		List<WebElement> empName=driver.findElements(By.xpath("//table[id='resultTable']/tbody/tr/td/a"));
		
		for (int i = 1; i < empName.size(); i++) {
			String rowText = empName.get(i - 1).getText();
			// System.out.println(rowText);
			if (rowText.contains("Zara ")) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + "]/td[1]")).click();
						
				driver.findElement(By.cssSelector("input[id='btnDelete']")).click();
			}
		}
		Thread.sleep(3000);
		driver.quit();
		}
	}