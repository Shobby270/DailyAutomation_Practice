package dataPickerExample;

import org.testng.annotations.DataProvider;

public class DynamicData {
	
	
	
	
	@DataProvider(name="yearData")
	public static String[] EntYear()
	{
		String[]year= {"1992","2001","1996"};
		
		return year;
	}

}
