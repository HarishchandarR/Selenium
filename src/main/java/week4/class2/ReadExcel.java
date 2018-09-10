package week4.class2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//To read contents from excel file and print the contents
public class ReadExcel {

	public String[][] excelData(String sheetname) throws IOException {
//open workbook
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+sheetname+".xlsx");
//go to sheet
		XSSFSheet wSheet = wBook.getSheetAt(0);		
//go to row
		int rowcount = wSheet.getLastRowNum();
		int cellcount = wSheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row = wSheet.getRow(i);					
//go to cell		
		for(int j=0;j<cellcount;j++) {
		XSSFCell cell = row.getCell(j);
//Read the data from the cell
		//String data = cell.getStringCellValue();
		data[i-1][j] = cell.getStringCellValue();
		System.out.println(data);
		//System.out.println(row.getCell(1).getStringCellValue());
		}		
		}
		wBook.close();
		return data;
	}
}
