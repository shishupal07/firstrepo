package com.demoqa.pageobject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;


public class TextBox extends Baseclass{
	@Test
	public void Testkbox() throws InterruptedException {
extent.createTest("Testbox");
			driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
		

			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Shishupal");

			driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("dagdeshishupal@gmail.com");

			driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Khardi pune");
			
			driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Khardi pune");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='submit']")).click();
			
extent.flush();
			

	}
	
}
