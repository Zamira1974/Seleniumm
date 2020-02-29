package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*TC 2: Radio Buttons Practice  
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Input Forms” links
Click on “Radio Buttons Demo” links
Click on any radio button in “Radio Button Demo” section.
Verify correct checkbox is clicked
Click on any radio button in “Group Radio Buttons Demo” section.
Verify correct checkbox is clicked
Quit browser
*/

public class RadioButtonTC2 extends CommonMethods {

	public static final String URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {

		// 1. Opening browser with URL from extended class CommonMethods();
		CommonMethods.setUp("chrome", URL);
		Thread.sleep(2000);
		// open “Input Forms” links
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		Thread.sleep(1000);

		// open Radio Button Demo
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		Thread.sleep(1000);

		// Find one webelement
		WebElement femaleRadioB = driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']"));

		// This will return boolean value, true if selected, false if not selected
		System.out.println(femaleRadioB.isSelected());// false
		femaleRadioB.click();

		// This will return boolean value, true if selected, false if not selected
		System.out.println(femaleRadioB.isSelected());// true
		System.out.println("*******************************");
		Thread.sleep(3000);
		
		List<WebElement> radioButtons=driver.findElements(By.name("optradio"));
		
			
		for(int i=0; i<radioButtons.size(); i++) {
			radioButtons.get(i).click();
		}
	
		
//		for(int i=0; i<radioButtons.size(); i++) {
//		boolean isSelected=	radioButtons.get(i).isSelected();
//		System.out.println(isSelected);	
//		
//		
//		if(!isSelected) {
//				radioButtons.get(i).click();
//				System.out.println(isSelected);
//				Thread.sleep(1000);
//			}
//	}
		driver.quit();
	}
}
