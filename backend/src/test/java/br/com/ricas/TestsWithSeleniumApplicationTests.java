package br.com.ricas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

 class TestsWithSeleniumApplicationTests {
 

	@Test
	public void shouldCreateAnUser() {
		/*Configure your gecko
		System.setProperty("webdriver.gecko.driver", "/home/ricardo/Downloads/geckodriver-v0.27.0-linux64/geckodriver");
		*/
		
		FirefoxDriver driver = new FirefoxDriver();
 		driver.get("http://localhost:4200/adduser");

		WebElement name = driver.findElement(By.name("name"));
		WebElement email = driver.findElement(By.name("email"));

		name.sendKeys("user_selenium");
		email.sendKeys("selenium@test.com");

		WebElement saveButton = driver.findElement(By.name("btnAdd"));
		saveButton.click();

		boolean findName = driver.getPageSource().contains("user_selenium");
		boolean findEmail = driver.getPageSource().contains("selenium@test.com");

		assertTrue(findName);
		assertTrue(findEmail);

	}

}
