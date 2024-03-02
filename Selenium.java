package com.example.demo;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;
public class Selenium {

	public static void main(String args[])
	{
		try
		{
			
		
		//Chrome webdriver is taken initially
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> prefs = new HashMap<>();
		    prefs.put("plugins.always_open_pdf_externally", true);
		  //  prefs.put("download.default_directory", "D:\\selenium"); THis downloads the file in provided folder
		        options.setExperimentalOption("prefs", prefs);
				WebDriver driver = new ChromeDriver(options);
				
		
		
		
		driver.manage().window().maximize();
		driver.get("https://www.manit.ac.in/");	
		//Close the pop up
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		//Open the image src Notice/Circular
		driver.findElement(By.xpath("//a[starts-with(text(),'Notice/Circular')]")).click();
		//Opens the first instance of notice-text to download the latest pdf
		// Wait for the first notice-text to be clickable
		
        WebElement firstNoticeText = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".notice-text a")));
        firstNoticeText.click();
		
		 
	}
		catch(Exception e)
		{
			System.out.println("The exception encountered is:"+e);
		}
}
}
