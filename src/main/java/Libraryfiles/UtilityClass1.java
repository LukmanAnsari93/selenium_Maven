package Libraryfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass1
{
	//this mathod is use for test data from excelsheet
	
		public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	    {
			FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\selenium_Maven\\Testdata\\seleniumExcel.xlsx");
			 Sheet Sh = WorkbookFactory.create(file).getSheet("DDF");
			 String value = Sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
	         return value;
			
		}
		
		public static void captureSS(WebDriver driver,int TCID) throws IOException {
			
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\HP\\eclipse-workspace\\selenium_Maven\\Screenshot\\TestCaseID"+TCID+".jpg");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		}
		public static String getPfdata(String key) throws IOException 
		{
			FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\selenium_Maven\\propertyFile.properties");
			Properties p=new Properties();
			p.load(file);
			String value=p.getProperty(key);
			return value;
			
			
			
		}
}
