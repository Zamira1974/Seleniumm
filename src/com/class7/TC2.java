package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

/*TC 2: Verify element is clickable
 1.Open chrome browser
 2.Go to “https://the-internet.herokuapp.com/”
 3.Click on “Click on the “Dynamic Controls” link
 4.Select checkbox and click Remove
 5.Click on Add button and verify “It's back!” text is displayed
 6.Close the browser
*/
public class TC2 extends CommonMethods {

	public static void main(String[] args) {

		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		// select Checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		// click Remove button
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// click button Add
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		// explicitly wait
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		// verify if “It's back!” text is displayed
		String expectedText="It's back!";
		String actualText = driver.findElement(By.xpath("//p[@id='message']")).getText();
		
		if (actualText.equals(expectedText)) {
			System.out.println("Test case Pass");

		} else {
			System.out.println("Test case Fail ");
		}
		driver.close();
	}
}
