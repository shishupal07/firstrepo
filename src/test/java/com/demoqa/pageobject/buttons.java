package com.demoqa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

public class buttons extends Baseclass {

	@Test
	public void Buttons() throws InterruptedException {
		
		extent.createTest("Buttons");
		WebElement button = driver
				.findElement(By.xpath("//span[normalize-space()='Buttons']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", button);
		Thread.sleep(1000);
		button.click();
		
		WebElement doubleclick=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		System.out.println(doubleclick.getText());
		Thread.sleep(1000);
		WebElement rightclick=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		System.out.println(rightclick.getText());
		Actions act=new Actions (driver);
		act.doubleClick(doubleclick).build().perform();
		
		act.contextClick(rightclick).build().perform();
		Thread.sleep(1000);
		//need to check
		
		WebElement Clickbutton=driver.findElement(By.xpath("//button[@id='DducL']"));
	
		Clickbutton.click();
		extent.flush();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	}
