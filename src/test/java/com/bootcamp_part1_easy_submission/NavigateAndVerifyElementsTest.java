package com.bootcamp_part1_easy_submission;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateAndVerifyElementsTest {

	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
	}

	@Test(priority = 1)
	public void testNavigateToWebsiteConfirm() {

		System.out.println("Title of the landingpage of rediff is: " + driver.getTitle());

		String actualTitle = driver.getTitle();
		String expectedTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Rediff url is working fine");
		} else {
			System.out.println("the url is not correct");
		}
	}

	@Test(priority = 2)
	public void testNewPageValidation() {

		WebElement moneyLink = driver.findElement(By.linkText("Money"));
		WebElement businessemaillLink = driver.findElement(By.linkText("Business Email"));
		if (moneyLink.isDisplayed() && moneyLink.isEnabled() && businessemaillLink.isDisplayed()
				&& businessemaillLink.isEnabled()) {
			System.out.println("The validations are correct");
		} else {
			System.out.println("Validations are incorrect");
		}
	}

	@Test(priority = 3)
	public void testNavigateNewPageAndVerifyElements() {
		driver.findElement(By.xpath("//a[@title='Online Shopping']")).click();
		WebElement redifflogo = driver.findElement(By.xpath("//img[@alt='rediff Shopping']"));
		WebElement MenuButton = driver.findElement(By.xpath("//span[normalize-space()='Tata CLiQ Luxury']"));
	
		if (redifflogo.isDisplayed() && redifflogo.isEnabled() && MenuButton.isDisplayed() && MenuButton.isEnabled()) {
			System.out.println("This presence of certain elements on new page ");
		} else {
			System.out.println("New page elements are not located");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();

	}
}
