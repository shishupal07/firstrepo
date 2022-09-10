package com.demoqa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demoqa.base.Baseclass;

public class checkbox extends Baseclass {

	
        @Test
        public void checkbox() throws InterruptedException {
        	
        	
        	extent.createTest("checkbox");
        	
    		driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();
    		Thread.sleep(1000);
    		WebElement sd =driver.findElement(By.xpath("//span[@class='rct-checkbox']//*[name()='svg']"));
    		sd.click();
    		System.out.println(sd.isSelected());
    		extent.flush();
    		
        }
        
		
		
		
	}


