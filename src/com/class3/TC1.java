package com.class3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*TC 1: HRMS Application Login: 
 * 1.Open chrome browser
 * 2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
 * 3.Enter valid username and password
 * 4.Click on login button
 * 5.Then verify Syntax Logo is displayed.
 * */

public class TC1 {

	public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		//find Webelement - login
		WebElement userName=driver.findElement(By.xpath("//*[@id='txtUsername']"));
		userName.sendKeys("Admin");
		userName.clear();
		userName.sendKeys("VanEarl");
		
		//find Webelement - password
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("VanEarl@&12");
		//find Webelement - login button
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		Thread.sleep(2000);
		
		//Verifying if Syntax Logo is displayed or not
		WebElement message =driver.findElement(By.xpath("//img[contains(@alt, 'OrangeHRM')]"));
		System.out.println("The Syntax Logo is displayed: "+message.isDisplayed());
		
		
		driver.close();
	}

}
