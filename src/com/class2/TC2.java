package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC2 {
/**TC 2: 
 * Mercury Tours Registration: 
 * 1.Open chrome browser
 * 2.Go to “http://newtours.demoaut.com/”
 * 3.Click on Register Link 
 * 4.Fill out all required info
 * 5.Click Submit
 * 6.User successfully registered
 * */

	public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			Thread.sleep(2000);

			WebDriver driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			Thread.sleep(2000);

			WebElement Register=driver.findElement(By.xpath("//a[contains(@href, 'mercuryregister.php')]"));
			Register.click();
			
			driver.findElement(By.linkText("REGISTER")).click();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Anna");
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("James");
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("345-7650900");
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("annajames@yahoo.ru");
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Jacksonville");
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("32256");
			driver.findElement(By.xpath("//input[contains(@src,'/images/form')]")).click();
			
			Thread.sleep(2000);
			driver.close();

	}
}

