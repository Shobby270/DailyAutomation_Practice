package testNG_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGPrograms {
	
	@Test
	
	public void brws1()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
