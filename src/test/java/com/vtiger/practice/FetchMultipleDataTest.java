package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataTest 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fos = new FileInputStream("./src/test/resources/Data.xlsx");
	Workbook wb = WorkbookFactory.create(fos);
	Sheet sheet = wb.getSheet("Sheet2");
	for(int i = 0; i<=sheet.getLastRowNum();i++)
	{
		for(int j = 0; j<sheet.getRow(i).getLastCellNum(); j++)
		{
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		}
	}
}
}
