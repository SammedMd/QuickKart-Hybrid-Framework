
package utilities;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
   private static Workbook workbook;
   private static Sheet sheet;

   
   //set Excel File and Sheet
   public static void setExcelFile(String sheetName) {
	   try {
		   File src = new File("src/main/resources/testdata/Testdata.xlsx");
	      FileInputStream fis = new FileInputStream(src);
	      workbook = WorkbookFactory.create(fis);
	    		  sheet = workbook.getSheet(sheetName);
	   } catch (Exception e){
		   e.printStackTrace();
		   throw new RuntimeException("Excel file not found or unreadable:" + e.getMessage());
	   }
   } 
     //Get cell data by sheet name, row, column
   public static String getCellData(String sheetName, int rowNum, int colNum) {
	   try {
		   setExcelFile(sheetName);
		   Row row = sheet.getRow(rowNum);
		   Cell cell = row.getCell(colNum);
		   
		   if (cell == null) return "";
		   
		   switch (cell.getCellType()) {
		   case STRING:
			   return cell.getStringCellValue();
			   
		   case NUMERIC: 
			   return String.valueOf((long) cell.getNumericCellValue());
			   
		   case BOOLEAN:
			   return String.valueOf(cell.getBooleanCellValue());
		   
		   case FORMULA:
			   return cell.getCellFormula();
			
			   default:
				   return "";
		   }
	   } catch (Exception e) {
		   e.printStackTrace();
		   return "Error" + e.getMessage();
	   }
   }
   
   public static int getRowCount(String sheetName) {
	   try {
		   setExcelFile(sheetName);
		   return sheet.getLastRowNum();
	   } catch(Exception e) {
		   e.printStackTrace();
		   return 0;
	   }
   }
public static Object[][] getExcelData(String sheetName) {
	setExcelFile(sheetName);
	int rowCount = sheet.getLastRowNum();
	int colCount = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rowCount][colCount];
	
	for(int i = 1; i <= rowCount; i++) {
		for(int j = 0; j < colCount; j++) {
			data[i -1][j] = getCellData(sheetName, i, j);
			
		}
	}
	return data;
}

}
