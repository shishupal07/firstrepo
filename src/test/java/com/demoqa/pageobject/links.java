package com.demoqa.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class links extends Baseclass {

	@Test
	public void Links() throws InterruptedException {
		extent.createTest("Links");
		WebElement link = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(1000);
		link.click();

		driver.findElement(By.xpath("//a[@id='simpleLink']"));
		
		String actualtitle = driver.getTitle();
		String expectedtitle = "ToolsQA";
		Assert.assertEquals(actualtitle, expectedtitle);
		Thread.sleep(1000);
		String tab = Keys.chord(Keys.CONTROL, Keys.RETURN);

		driver.findElement(By.xpath("//a[@id='dynamicLink']")).sendKeys(tab);
		
		String actualtitle1 = driver.getTitle();
		String expectedtitle1 = "ToolsQA";
		Assert.assertEquals(actualtitle1, expectedtitle1);
		extent.flush();
	}
}
