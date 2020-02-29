package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

/*TC 1: Verify element is present

Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Loading” link
Click on “Example 1...” and click on “Start”
Verify element with text “Hello World!” is displayed
Close the browser
 * */

public class Task1 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Dynamic Loading']")).click();
		
		driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']")).click();
		driver.findElement(By.xpath(" //button[text()='Start']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		boolean visibleText = driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		if (visibleText) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();
	}
}