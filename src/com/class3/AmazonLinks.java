package com.class3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC 1: Amazon link count: 1.Open chrome browser
 *2.Go to “https://www.amazon.com/”
 *3.Get all links
 *4.Get number of links that has text
 *5.Print to console only the links that has text
 */

public class AmazonLinks {

	public static final String URL="https://amazon.com";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("zama-kaz@mail.ru");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("koshka1974");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
		List<WebElement> links=driver.findElements(By.tagName("span"));
		System.out.println("Size of all Links= "+links.size());
		
		for(WebElement link : links) {
			String allLink = link.getText();
			
			if(!allLink.isEmpty()) {
				System.out.println(allLink);
			}
		}
		Thread.sleep(2000);
		driver.close();
		
	}
}
