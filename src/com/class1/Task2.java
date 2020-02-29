package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
/*TC 2: Syntax Page URL Verification: 
Open chrome browser
Navigate to “https://www.syntaxtechs.com/”
Navigate to “https://www.google.com/”
Navigate back to Syntax Technologies Page
Refresh current page
Verify url contains “Syntax”
 */
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        
        driver.get("http://google.com");
        Thread.sleep(3000);
        
        driver.navigate().to("https://www.syntaxtechs.com/");
        Thread.sleep(3000);
        
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        
        driver.navigate().refresh();
     
        driver.close();
	}

}
