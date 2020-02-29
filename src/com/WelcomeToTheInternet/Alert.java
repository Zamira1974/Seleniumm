package com.WelcomeToTheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Alert extends CommonMethods {
/*Task 2:
Using the toolsqa Website, write code to accept an alert when clicking
on 'Alert Box' button and write code that accepts an
alert when clicking on 'Timing Alert' button -
DO NOT USE Thread.Sleep();
 * */
	public static void main(String[] args) {

		setUp("chrome", Constants.TOOLSQA_URL);
		
		driver.findElement(By.id("alert")).click();
		driver.findElement(By.id("timingAlert")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		acceptAlert();

		driver.close();
	}

}
