package dataPickerExample;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker extends DynamicData {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

	}

	
	
	
	@Test(dataProvider = "yearData")
	public void dataFromTable(String year) {
		
		driver.findElement(By.id("datetimepicker1")).click();
		WebElement month = driver.findElement(By.xpath("//select[@class='flatpickr-monthDropdown-months']"));
		
		Select select = new Select(month);
		select.selectByVisibleText("February");
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).clear();
		
		driver.findElement(By.xpath("//input[@class='numInput cur-year']")).sendKeys(year);
		
		driver.findElement(By.xpath("//span[text()='5']")).click();
		

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(Duration.ofSeconds(2));
		driver.quit();
	}

}
