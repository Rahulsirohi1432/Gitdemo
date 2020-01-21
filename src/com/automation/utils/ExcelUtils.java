package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.Config.Constants;

public class ExcelUtils {

	
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;

	// This method is to set the File path and to open the Excel file
	// Pass Excel Path and SheetName as Arguments to this method

	public static void setExcelFile(String Path) throws IOException {
		FileInputStream fs = new FileInputStream(Path);
		workbook = new XSSFWorkbook(fs);

	}

	// This method is to read the test data from the Excel cell
	// In this we are passing Arguments as Row Num, Col Num & Sheet Name
	
	public static String getcelldata(int RowNum, int ColNum, String SheetName) {

		sheet = workbook.getSheet(SheetName);
		try {
			cell = sheet.getRow(RowNum).getCell(ColNum);
			String Celldata = cell.getStringCellValue();
			return Celldata;

		} catch (Exception e) {
			return "";
		}
	}

	// This method is to get the row count used of the excel sheet
	
	public static int getRowCount(String SheetName) {
		sheet = workbook.getSheet(SheetName);
		int number = sheet.getLastRowNum()+1;
		return number;
	}

	// This method is to get the Row number of the test case
	// This methods takes three arguments(Test Case name , Column Number & Sheet
	// name)
	
	public static int getRowContains(String sTestCaseName, int ColNum, String SheetName) {
		int i;
		sheet = workbook.getSheet(SheetName);
		int rowcount = ExcelUtils.getRowCount(SheetName);
		for (i=0; i < rowcount; i++) {
			if (ExcelUtils.getcelldata(i, ColNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
				break;
			}
			
		}
		return i;
	}
	
	
	//This method is to get the count of the test steps of test case
	 //This method takes three arguments (Sheet name, Test Case Id & Test case row number)
	         public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
	         for(int i =iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
	         if(!sTestCaseID.equals(ExcelUtils.getcelldata(i, Constants.Col_TestCaseId, SheetName))){
	         int number = i;
	         return number;
	         }
	         }
	         sheet = workbook.getSheet(SheetName);
	         int number=sheet.getLastRowNum()+1;
	         return number;
	         }
	 
	     }

