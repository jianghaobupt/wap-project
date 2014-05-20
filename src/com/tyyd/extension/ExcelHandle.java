package com.tyyd.extension;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelHandle {
	
	public ExcelHandle(){
		
	}
	
	public static String readExcel(String excelPath, int sheetNu, int rowNu, int cellNu) throws Exception{
		/**
		 * read Excel file with the Path
		 * get cell in sheetNu, rowNu and cellNu
		 */
		String cellValue = null;
		
		FileInputStream fos = new FileInputStream(excelPath);
		HSSFWorkbook wb = new HSSFWorkbook(fos);
			
		HSSFSheet sheet = wb.getSheetAt(sheetNu);
		HSSFRow row = sheet.getRow(rowNu);
		
		try {
			HSSFCell cell = row.getCell(cellNu);
			
			if(HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
				cellValue = cell.getStringCellValue();
				//System.out.println("_________________"+cellValue);
			}
			if(HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
				cellValue = Long.toString((long)(cell.getNumericCellValue()));
				//System.out.println("_________________"+cellValue);
			}
			
			return cellValue;
		} catch (NullPointerException e) {
			return null;
		}


	}
	
	public static void writeExcel(String excelPath, String testCase) throws Exception{
		/**
		 * create Excel file in excelPath
		 * build two sheet which names are "TestSummary" and testcase detailinfo
		 */
		FileOutputStream fos = new FileOutputStream(excelPath);
		HSSFWorkbook wb = new HSSFWorkbook(); 
		
		HSSFSheet s1 = wb.createSheet(); 
		wb.setSheetName(0, "TestSummary");
		HSSFSheet s2 = wb.createSheet();
		wb.setSheetName(1, testCase+"_DetailInfo");
		
		HSSFRow s1row = s1.createRow(0);
		HSSFRow s2row = s2.createRow(0);
		
		s1row.createCell(0).setCellValue("Total TCs");
		s1row.createCell(1).setCellValue("Run TCs");
		s1row.createCell(2).setCellValue("Passed TCs");
		s1row.createCell(3).setCellValue("Failure TCs");
		s1row.createCell(4).setCellValue("NoRun TCs");
		
		s2row.createCell(0).setCellValue("SubTestCase"); 
		s2row.createCell(1).setCellValue("TestResult");
		s2row.createCell(2).setCellValue("AssertPointCheck");
		s2row.createCell(3).setCellValue("ScreenShot");
		s2row.createCell(4).setCellValue("Processor");

		wb.write(fos);
		fos.close();
	}
	
	public static void modifyExcel(){
		//TODO: 增加修改excel文档的方法
	}

}
