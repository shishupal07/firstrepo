package com.demoqa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

public class Webtables extends Baseclass{
	@Test
	public void checkbox() throws InterruptedException {
		extent.createTest("Webtable");
		WebElement radiobutton = driver
				.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", radiobutton);
		Thread.sleep(1000);
		radiobutton.click();
		//before addingthe data
		
		List<WebElement>List=driver.findElements(By.xpath("//div[@role='grid']//div[@role='rowgroup']"));
		System.out.println(List.size());
		for(WebElement ele:List) 
		{
			String value=ele.getText();
			System.out.println(value);
		}

		driver.findElement(By.xpath("\r\n" + "//button[@id='addNewRecordButton']")).click();

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Shishupal");

		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Dagde");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("dagdeshishupal@gmal.com");

		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("27");

		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("40000");

		driver.findElement(By.xpath("//input[@id='department']")).sendKeys("QA");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();

		//After adding the data
				List<WebElement>List1=driver.findElements(By.xpath("//div[@role='grid']//div[@role='rowgroup']"));
				System.out.println(List1.size());
				for(WebElement ele1:List1) 
				{
					String value1=ele1.getText();
					System.out.println(value1);
				}
				extent.flush();
	}

}
