package com.WelcomeToTheInternet;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task extends CommonMethods{
	
/*As a stakeholder, I want to be able to confirm that there are 45 links on the 
“Welcome to the Internet” home page
As a stakeholder, I want to be able to verify that the text to each hyperlink and 
match each hyperlink with the respective text
Note for testers: Please write clean code and comment on each line of code what is 
the function being performed so that our client side members can read your code
and understand what is going on
 * */
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.welcomeToTheInternetUrl);
	
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		int numberOfAllLinks = allLinks.size();
		System.out.println(numberOfAllLinks);
		Iterator<WebElement> iterator =allLinks.iterator();
		while(iterator.hasNext()) {
			WebElement elem=iterator.next();
			System.out.println(elem.getText()+ " = " +elem.getAttribute("href"));
			}
	driver.quit();
	}
}
