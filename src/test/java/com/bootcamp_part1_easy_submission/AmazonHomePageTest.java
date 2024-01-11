package com.bootcamp_part1_easy_submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHomePageTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void testTitleAndURL() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
