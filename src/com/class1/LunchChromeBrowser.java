package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
			//					KEY						VALUE		
		System.setProperty("webdriver.chrome.driver", "/Users/zamiradauyekeyeva/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		//http ---> hypertext transfer protocol
		driver.get("http://google.com");
		Thread.sleep(1000);
		//Browser navigation  commands.

//it will navigate to a given URL
		driver.navigate().to("http://www.facebook.com");
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		driver.close();
	}
}
