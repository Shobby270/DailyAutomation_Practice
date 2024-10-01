package webTablersProgram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaticWebTable {
	
	
	WebDriver driver;
	
	
	
	
	@BeforeMethod
	public void setUp()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		
		
	}
	
	@Test
	public void dataFromTable()
	{
       String expName= "Vega";
			
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
				
		

		
		for(int i=0; i<row.size(); i++)
		{
			if(row.get(i).getText().contains(expName))
			{
			
			
		List<WebElement> exprow = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+(i+1)+"]/td"));
		
		for(WebElement exdata:exprow)
		{
			System.out.println(exdata.getText());
			
		}
		break;
		}
			
}
	
	
}
	


				
			
		
		
		
		
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
