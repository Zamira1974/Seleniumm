package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

/*TC 3: Verify element is enabled
1.Open chrome browser
2.Go to “https://the-internet.herokuapp.com/”
3.Click on “Click on the “Dynamic Controls” link
4.Click on enable button
5.Enter “Hello” and verify text is entered successfully
6.Close the browser
*/

public class TC3 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();

		// Click on enable button
		driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
		// add wait webdriver
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// initialize
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("button[onclick='swapInput()']")));

		// enter “Hello” in the box
		String textToEnter="Hello";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(textToEnter);
		// get the value of the text entered.
		String enteredText = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
	

		if (enteredText.equals(textToEnter)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");

		}
		driver.close();
	}
}
