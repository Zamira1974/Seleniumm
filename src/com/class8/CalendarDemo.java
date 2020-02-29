package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CalendarDemo extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", Constants.HRMS_URL);
		// login into HRMS
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		//

		Thread.sleep(5000);
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();

		// step 1: click on calendar
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();

		Thread.sleep(2000);
		// step 2: get all cells
		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell : cells) {
			// retrieve text and check if it matches expected value
			if (cell.getText().equals("16")) {
				// once found click and break
				cell.click();
				break;
			}
		}

		Thread.sleep(4000);
		driver.quit();
	}
}