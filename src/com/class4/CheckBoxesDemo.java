package com.class4;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class CheckBoxesDemo extends CommonMethods {

	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {

		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		driver.manage().window().fullscreen();

		driver.findElement(By.linkText("Input Forms")).click();

		driver.findElement(By.linkText("Checkbox Demo")).click();

		WebElement ageCheckBox = driver.findElement(By.id("isAgeSelected"));
		// Checking if the checkbox is selected
		if (!ageCheckBox.isSelected()) {
			ageCheckBox.click();// clicks only if not selected
		}
		Thread.sleep(1000);
		ageCheckBox.click();

		System.out.println("**********Group of Check Boxes********");

		// Storing the group of check boxes
		List<WebElement> groupCheckBox = driver.findElements(By.xpath("//input[@class='cb1-element']"));

		if (!groupCheckBox.isEmpty()) {// checking if groupCheckBox is empty or not
			Iterator<WebElement> it = groupCheckBox.iterator();// adding the list to iterator
			while (it.hasNext()) {// if there is next element in the list, then go to it.
				it.next().click();// click on the next element
				Thread.sleep(1000);
			}
		} else {
			System.err.println("List is empty, check your xpath");
		}
		driver.close();
	}
}