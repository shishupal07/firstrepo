package com.demoqa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radiobutton extends Baseclass {

	 @Test
     public void checkbox () {
     	
 		
 		driver.findElement(By.xpath("//span[normalize-space()='Radio Button']")).click();
 				
 		driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
 		
 		driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
 		
 		
 		
     }
}
