package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*TC 1: Table headers and rows verification
 * 1.Open chrome browser
 * 2.Go to “http://166.62.36.207/syntaxpractice/”
 * 3.Click on “Table” link
 * 4.Click on “ITable Data Search” link
 * 5.Verify tables consist of 4 rows and 7 columns
 * 6.Print name of all column headers 
 * 7.Print data of all rows
 * 8.Quit Browser
 * */
import com.utils.CommonMethods;

public class HomeWorkTC1 extends CommonMethods {

	public static void main(String[] args) {

		setUp("chrome", "http://166.62.36.207/syntaxpractice");
		// find WebEl “Table” link
		driver.findElement(By.linkText("Table")).click();
		// find WebEl “Table Data Search” link
		driver.findElement(By.linkText("Table Data Search")).click();

		// GET NUMBER OF ROWS
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows= " + rows.size());

		System.out.println("--------------ROW DATA---------------");
		Iterator<WebElement> it = rows.iterator();
		while (it.hasNext()) {
			String rowText = it.next().getText();
			System.out.println(rowText);
		}

		// GET NUMBER OF COLUMNS
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of columns= " + cols.size());

		System.out.println("-------------COLUMNS HEADERS-----------");

		for (WebElement col : cols) {
			String colText = col.getText();
			System.out.println(colText);

		}
		driver.quit();
	}

}
