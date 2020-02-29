package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
/*TC 1: Amazon Page Title Verification: 
Open chrome browser
Go to “https://www.amazon.com/”
Verify Title “Amazon.com: Online Shopping for 
Electronics, Apparel, Computers, Books, DVDs & more” 
is displayed
 * */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zamiradauyekeyeva/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();

		driver.get("http://google.com");
		Thread.sleep(2000);
		
		//driver.navigate().to("http://www.Amazon.com");
		//driver.navigate().to("https://github.com");
		driver.navigate().to("https://www.redfin.com");
		
		Thread.sleep(3000);
		driver.navigate().forward();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		driver.close();
	}

}
