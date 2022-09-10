package com.demoqa.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload {
	@Test(priority=1)
	public void download() throws InterruptedException, AWTException {

		String location = System.getProperty("user.dir") + "\\Downloads\\";
		HashMap<String, String> perf = new HashMap<String, String>();
		perf.put("download.default_directory", location);

		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", perf);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://demoqa.com/elements");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement upload = driver
				.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-7']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", upload);
		Thread.sleep(1000);
		upload.click();

		// download
		driver.findElement(By.xpath("//a[@id='downloadButton']")).click();
		driver.close();
	}
	
	// uploaded

	@Test(priority=2)
	public void upload() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement upload = driver
				.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-7']"));

		JavascriptExecutor jd = (JavascriptExecutor) driver;
		jd.executeScript("arguments[0].scrollIntoView();", upload);
		Thread.sleep(1000);
		upload.click();
		;

		WebElement samplefile = driver.findElement(By.xpath("//input[@id='uploadFile']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", samplefile);

		Robot rb = new Robot();
		rb.delay(2000);

		// put path to file in a clipbord

		StringSelection se1 = new StringSelection("C:\\Users\\samrat\\Downloads\\sampleFile (1)");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se1, null);
		// CTRL+V
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.delay(2000);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.delay(2000);
		// ENTER
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
driver.close();
	}

}
