package com.qa.Clockify.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book ;
	public static Sheet sheet ;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Thinksysuser\\eclipse-workspace\\SeleniumProject2020\\src\\main\\java\\com\\qa\\Clockify\\testdata\\ClockifyTestdata.xlsx";

	public static Object [][] getTestData(String sheetName) {
		
		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i = 0; i<sheet.getLastRowNum() ;i++) {
				for (int j= 0 ; j<sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			return data ;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
