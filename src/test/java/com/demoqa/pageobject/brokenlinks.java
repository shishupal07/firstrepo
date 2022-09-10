package com.demoqa.pageobject;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

public class brokenlinks extends Baseclass {
	@Test(priority=1)
	public void Validlink() throws InterruptedException {

		WebElement validlink = driver.findElement(By.xpath("//span[normalize-space()='Broken Links - Images']"));
		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", validlink);
		Thread.sleep(1000);
		validlink.click();

		driver.findElement(By.xpath("//a[normalize-space()='Click Here for Valid Link']"));

		String validlinktitle = driver.getTitle();
		String expectedtitle = "ToolsQA";
		Assert.assertEquals(validlinktitle, expectedtitle);
		Thread.sleep(1000);

	}

	@Test(priority=2)
	public void Brokenlink() throws InterruptedException {

		WebElement validlink = driver.findElement(By.xpath("//span[normalize-space()='Broken Links - Images']"));
		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", validlink);
		Thread.sleep(1000);
		validlink.click();

		WebElement broken = driver.findElement(By.xpath("//a[normalize-space()='Click Here for Broken Link']"));

		String url = broken.getAttribute("href");
	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}
}
