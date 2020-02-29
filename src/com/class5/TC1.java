package com.class5;
/*TC 1: JavaScript alert text verification
 * 1.Open chrome browser
 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
 * 3.Click on “Alerts & Modals” links
 * 4.Click on “Javascript Alerts” links
 * 5.Click on button in “Java Script Alert Box” section
 * 6.Verify alert box with text “I am an alert box!” is present
 * 7.Click on button in “Java Script Confirm Box” section
 * 8.Verify alert box with text “Press a button!” is present
 * 9.Click on button in “Java Script Alert Box” section
 * 10.Enter text in the alert box
 * 11.Quit browser
 * */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;;

public class TC1 extends CommonMethods {
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("Alert text:   " + alert.getText());
		alert.accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("Text of Second Alert: " + alert1.getText());
		alert1.dismiss();
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(1000);
		Alert alert3 = driver.switchTo().alert();
		alert.sendKeys("Syntax");
		alert.accept();
		boolean isDisplayed = driver.findElement(By.id("prompt-demo")).isDisplayed();
		System.out.println(isDisplayed);
		driver.close();
	}
}
