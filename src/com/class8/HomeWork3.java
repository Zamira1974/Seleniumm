package com.class8;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

/*TC 1: Leave List Search Validation
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
Login into the application
Select Leave List
Select from December 1, 2019 until January 31, 2020
Check only Pending approval
Click on Search
Validate “No Records Found” is displayed
Quit the browser
*/
public class HomeWork3 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// open browser.
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.linkText("Leave"))));
		// select Leave List
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		Thread.sleep(3000);

		// open calendar from
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(3000);
		// Select from December 1, 2019
		WebElement element1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select s = new Select(element1);
		s.selectByVisibleText("2019");
		WebElement element = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select select = new Select(element);
		select.selectByVisibleText("Dec");
		Thread.sleep(3000);

		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		Thread.sleep(2000);
		for (WebElement cell : cells) {
			if (cell.getText().equals("1")) {
				cell.click();
				break;
		}}
		// open calendar to
		driver.findElement(By.xpath("//*[@id=\"frmFilterLeave\"]/fieldset/ol/li[2]/img")).click();
		// select month
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
		Select select1 = new Select(element2);
		select1.selectByVisibleText("Jan");
		Thread.sleep(3000);
		// select year
		WebElement element3 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select s1 = new Select(element3);
		s1.selectByVisibleText("2020");
		Thread.sleep(3000);

		// select day
		List<WebElement> cells1 = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		for (WebElement data : cells1) {
			if (data.getText().equals("31")) {
				data.click();
				break;
			}
		}

		// Check only Pending approval. Click on Search
		driver.findElement(By.xpath("//input[@id=\"leaveList_chkSearchFilter_1\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"btnSearch\"]")).click();

		// Validate “No Records Found” is displayed
		String Expected_Value = "No Records Found";
		List<WebElement> row = driver.findElements(By.xpath("//table[@id=\"resultTable\"]/tbody/tr"));
		for (WebElement data : row) {
			String Actual_Value = data.getText();
			if (Actual_Value.equals(Expected_Value)) {
				System.out.println("Test Case Pass");
			} else {
				System.out.println("Test case Fail");
			}
		}
	}
}