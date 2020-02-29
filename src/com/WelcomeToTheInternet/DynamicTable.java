package com.WelcomeToTheInternet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DynamicTable extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[id='menu_recruitment_viewRecruitmentModule']/b")).click();

		driver.findElement(By.linkText("Candidates")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
		String firstPart = "//table[@id = 'resultTable']/tbody/tr[";
		String secondPart = "]/td[3]";
		String thirdPart = "]/td[1]";
		int numberOfRows = rows.size();
		System.out.println(numberOfRows);
		for (int i = 1; i <= numberOfRows; i++) {
			String namePresent = driver.findElement(By.xpath(firstPart + i + secondPart)).getText();
			System.out.println(namePresent);
			if (namePresent.contains("Syntax")) {
				driver.findElement(By.xpath(firstPart + i + thirdPart)).click();
				break;
			} else {
				System.out.println("Text not present");
			}
		}
		driver.quit();
	}
}
