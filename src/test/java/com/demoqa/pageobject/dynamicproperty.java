package com.demoqa.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

public class dynamicproperty extends Baseclass {

	@Test
	public void checkbox() throws InterruptedException {
		extent.createTest("checkbox");
		WebElement link = driver.findElement(By.xpath("//span[normalize-space()='Dynamic Properties']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(1000);
		link.click();

		WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button=Mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='colorChange']")));
		button.click();
		extent.flush();
	}
}
