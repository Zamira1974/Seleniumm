package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*TC 2: HRMS Application Negative Login:
 1.Open chrome browser
 2.Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
 3.Enter valid username
 4.Leave password field empty
 5.Verify error message with text “Password cannot be empty” is displayed.
 * */

public class TC2 {
		
		public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
		
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			WebDriver driver=new ChromeDriver();
			driver.get(URL);
			
			//find Webelement - login
			WebElement userName=driver.findElement(By.xpath("//*[@id='txtUsername']"));
			userName.sendKeys("VanEarl");
			
			//find Webelement - password
			driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("");
			
			//find Webelement - login button
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			//Verify if is error message with text “Password cannot be empty” is displayed.
			WebElement errorMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));
			System.out.println("Error message is displayed: "+errorMessage);
			
			if(errorMessage.isDisplayed()) {
			String msg=errorMessage.getText();
			if(msg.equals("Password cannot be empty")) {
				System.out.println("Correct message is displayed");
			}else {
				System.out.println("Incorrect message is displayed");
			}
		}
			Thread.sleep(2000);
			driver.close();
	}

}
