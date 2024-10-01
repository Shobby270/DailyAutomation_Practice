package testNG_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FSSinterviewQuetion {
	
	@Test
	public void fetchGoogleLang() {
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.google.com/");
	
	List<WebElement>lang=driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
	
	

	for(WebElement language:lang)
	{

	System.out.println(language.getText());

	}
	}

}
