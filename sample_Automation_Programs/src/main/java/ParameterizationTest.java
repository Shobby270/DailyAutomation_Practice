import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ParameterizationTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		
		  FileInputStream file = new
		  FileInputStream("D:\\Framework_Workspace\\sample_Automation_Programs\\resource\\New Microsoft Excel Worksheet.xlsx"
		  );
		  
		  String
		  aaa=WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).
		  getStringCellValue(); System.out.println(aaa);
		  
		 

		System.out.println("hello");

	}

}
