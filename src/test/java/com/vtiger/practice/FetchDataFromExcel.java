package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
	
		//convert the physical file into java readable object
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		// open the excel
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//get the control on sheet
		
		Sheet sheet = wb.getSheet("Sheet1");
		
		//get the control on row
		
		Row row = sheet.getRow(1);
		
		//get the control on cell
		
		Cell cell = row.getCell(0);
		
		//fetch the data from the cell
		
	    String data = cell.getStringCellValue();
		
		System.out.println(data);
		
	}
}
