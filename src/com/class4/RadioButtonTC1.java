package com.class4;

import org.openqa.selenium.By;
import com.utils.CommonMethods;

public class RadioButtonTC1 extends CommonMethods {
/*
 * 1.Open Chrome Browser
 * 2.Go to "http://jiravm.centralus.cloudapp.azure.com:8081/index.html"
 * 3.Click on "Input Forms" links
 * 4.Click on "Simple Form Demo" links
 * 5. Get all input boxes from the page
 * 6. Enter "Hello" to each text box
 * Close browser
*/	
	
	public static final String URL= "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	
	public static void main(String[] args) throws InterruptedException {
	
		CommonMethods.setUp("chrome", URL);
		Thread.sleep(2000);
		
		//find webElement "Input Forms"
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		
		// find webElement "Simple Form Demo" links
		driver.findElement(By.linkText("Simple Form Demo")).click();
		Thread.sleep(2000);
		
		//Get all input boxes from the page
		driver.findElement(By.xpath("//*[@id='user-message']")).sendKeys("Hello");
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //*[@id='sum1']")).sendKeys("Hello");
		driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys("Hello");
		Thread.sleep(2000);
		
		driver.close();
	}
}
