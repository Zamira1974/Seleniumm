package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {
/*Using Xpath ONLY
TC 1: Facebook login: 
Open chrome browser
Go to “https://www.facebook.com/”
Enter valid username and valid password and click login 
User successfully logged in
 * */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("zama.ny1974@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Koshka1974");
		driver.findElement(By.xpath("//input[@id='u_0_b']")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
