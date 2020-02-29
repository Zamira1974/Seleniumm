package com.class9;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import com.utils.CommonMethods;

public class AmerAirlinesCalendar extends CommonMethods {
/*TC 1: Table headers and rows verification
Open chrome browser
Go to “https://www.aa.com/homePage.do”
Enter From and To
Select departure as May 14 of 2020
Select arrival as November 8 of 2020
Verify “Choose flights” text is displayed
Take s screenshot of the results
Close browser
 * */

		public static void main(String[] args) {
		
		//open chrome browser and Go to “https://www.aa.com/homePage.do”
		setUp("chrome","https://www.aa.com/homePage.do");
		
		
		driver.findElement(By.xpath("//input[@name='destinationAirport']")).sendKeys("JFK");
		
		//find WebE calendar 'Depart' icon
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		
		String departMonth="May", departDay="14";
	
		//look for depart month 'May' 
		boolean flag=false;
		while(!flag) {
			String monthValue=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	
			if(monthValue.equals(departMonth)) {
				flag=true;
				System.out.println(monthValue);
				break;
			}
			//look for expected month though the clicking next '>'
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		}
		
		//look for dayD (=departed day) '14'
		List<WebElement> dayTable=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for( WebElement dayD :dayTable) {
			if(dayD.getText().equals(departDay)) {
				System.out.println(dayD.getText());
				dayD.click();
				break;
			}
		}
		System.out.println("-----------------------RETURN DATE-------------------------");
		
		//find WebE calendar 'Return' icon
		driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm']/div[4]/div[2]/div/label/button")).click();
		
		String returnMonth="November", returnDay="8";
		
		//look for return month 'November'
		boolean flagi=false;
		while(!flagi) {
			String monthValue=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	
			if(monthValue.equals(returnMonth)) {
				flagi=true;
				System.out.println(monthValue);
				break;
			}
			//look for expected month though the clicking next '>'
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		//look for dayR (=return day) '8'
		List<WebElement> dayTable2=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td "));
		for( WebElement dayR :dayTable2) {
			if(dayR.getText().equals(returnDay)) {
				System.out.println(dayR.getText());
				dayR.click();
				break;
			}
		}
		 TakesScreenshot ts=(TakesScreenshot) driver;
         File screen=ts.getScreenshotAs(OutputType.FILE);
         driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
         try {
                FileUtils.copyFile(screen, new File("screenshots/AmericanAirlines/displayChooseFlight.png")); 
             }catch(IOException e) {
                 System.out.println(e.getMessage());
             }
        driver.quit();   
        }
	}

