package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*TC 1: Table headers and rows verification
1.Open chrome browser
2.Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
3.Login to the application
4.Verify customer “Susan McLaren” is present in the table
5.Click on customer details
6.Update customers last name 
7.Verify updated customers name is displayed in table
8.Close browser
 * */
public class HomeWork2 extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		// login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		// search for Susan McLaren

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		boolean customerPresent = false;
		String customer = "Susan McLaren";
		
		String newCredCard= "000000000000", newName = "!!!!!!";
		
		for (int i = 0; i < rows.size(); i++) {

			String rowText = rows.get(i).getText();

			// Verify if customer "Susan McLaren" present in the table
			if (rowText.contains(customer)) {
				customerPresent=true;
				System.out.println("Customer present in the table: "+ customerPresent);
		driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (i+1) + "]/td[13]")).click();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).clear();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys("Susan McDonald");
 
		newName=driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).getAttribute("value");

		// update payment info. clear old info and send new info
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).clear();
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("555554444333221");

		newCredCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).getAttribute("value");
	
		// click on update button
		driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
		break;
			}
		}
		
		List<WebElement> updatedRow = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		// Verify name and credit card are updated
		for (int i = 1; i < updatedRow.size(); i++) {
			String newRowText = updatedRow.get(i - 1).getText();
			if (newRowText.contains(newName) && newRowText.contains(newCredCard)) {
				System.out.println("Name: "+newName + ", CC: " +newCredCard);
				break;
			}
		}
		if (!customerPresent) {
			System.out.println("Customer is not found in the table");
		}
		 
		driver.findElement(By.id("ctl00_logout")).click();
		
		driver.quit();
	}
}
