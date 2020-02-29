package com.class3;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*TC 1: Amazon link count: 
 1.Open chrome browser
 2.Go to “https://www.amazon.com/”
 3.Get all links
 4.Get number of links that has text
 5.Print to console only the links that has text
 * */

public class TC3 {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.com");

List<WebElement>links=driver.findElements(By.tagName("a")); 
		System.out.println("Size of all links= "+links.size());
		
		for(WebElement link: links) {
			String allLinks=link.getText();
			
			if(!allLinks.isEmpty()) {
				System.out.println(allLinks);
			}
		}
		Thread.sleep(2000);
		driver.close();
	}

}
