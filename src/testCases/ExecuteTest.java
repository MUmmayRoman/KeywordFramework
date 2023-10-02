package testCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excelExportAndFileIO.ReadGuru99ExcelFile;
import operation.ReadObject;
import operation.UIOperation;

public class ExecuteTest {   // This class can Run/Execute the script.
	                         // keyword and Data driven framework almost everything is same, Only difference Keywords.

	@Test
	public void testLogin() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Roman's_WorkPlace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
		
		ReadObject object = new ReadObject();
		
		Properties allObjects = object.getObjectRepository();
		
		UIOperation operation = new UIOperation(webdriver);
		
		//Read Keyword Sheet
		Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx", "KeywordFramework");
		
		//Find number of rows in excel file
		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount + 1; i++) {
			//Check If row exists or not
			Row row = guru99Sheet.getRow(i);
			
			if(row != null)
			{
				//First Clicking Reset button
				//Print TestCase detail on console
				if(i > 1 && i < 4) {
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString() + "----" + row.getCell(4).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
					Thread.sleep(1000);
				}
				else if (i == 1) {
					System.out.println("FIRST TEST CASE STARTED");
					System.out.println("");
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(4).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), "", "", row.getCell(4).toString());
					Thread.sleep(1000);
				}
				else if( i == 4)
				{
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), "");
					Thread.sleep(1000);
				}
					
				//Second Clicking Login Button
				
				
				
				if(i > 5 && i < 8) {
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString() + "----" + row.getCell(4).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
					Thread.sleep(1000);
				}
				else if (i == 5) {
					System.out.println("SECOND TEST CASE STARTED");
					System.out.println("");
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(4).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), "", "", row.getCell(4).toString());
					Thread.sleep(1000);
				}
				else if( i == 8 )
				{
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), "");
					Thread.sleep(1000);
				}
				
				else if (i == 9) {
					System.out.println("END OF THE TESTCASE");
					System.out.println("");
					System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());
					
					//Call perform function to perform operation on UI
					operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), "");
					Thread.sleep(1000);
					
					Alert alert = webdriver.switchTo().alert();
					alert.accept();
				}

			}
			else
			{
				System.out.println("Row not found in Excel Sheet");
				Thread.sleep(1000);
					}
			
				}
		webdriver.close();
		webdriver.quit();
		Thread.sleep(1000);
		
			}
	
}
