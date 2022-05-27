package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains only common methods to handle excel
 * @author omc
 *
 */
public class GeneralExcelUtility {

	static Workbook wb;
	
	/**
	 * This method is used to print data into excel
	 * @param excelfilepath
	 * @throws IOException
	 */
	public static void saveExcel(String excelfilepath) throws IOException {
		FileOutputStream fos = new FileOutputStream(excelfilepath);
		wb.write(fos);
		
	}
	/**
	 * This method is used to set excel file input location
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 * @param message
	 */
	public static void setExcelFile(String sheetname,int rowNumber,int cellNumber,String value) {
		wb.getSheet(sheetname).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
			
	}
	/**
	 * This method is used to close the workbook
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException {
		wb.close();
	}
	/**
	 * This method is used to open the excel
	 * @param excelfilepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String excelfilepath) throws EncryptedDocumentException, IOException {
		FileInputStream fexcel = new FileInputStream(excelfilepath);
		wb = WorkbookFactory.create(fexcel);
	}
	/**
	 * This method is used to get data from excel
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 */
	public static String getDataFromExcel(String SheetName,int RowNumber,int CellNumber) {
		return wb.getSheet(SheetName).getRow(RowNumber).getCell(CellNumber).getStringCellValue();
	}
	/**
	 * This method is used to fetch multiple data from excel
	 * @param excelfilepath
	 * @param sheetname
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static Object[][] getMultipleDataFromExcel(String excelfilepath,String sheetname) throws EncryptedDocumentException, IOException {
			FileInputStream fos = new FileInputStream(excelfilepath);
			Workbook wb = WorkbookFactory.create(fos);
			Sheet sheet = wb.getSheet(sheetname);
			Object[][] arr=new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
			for(int i = 0; i<=sheet.getLastRowNum();i++)
			{
				for(int j = 0; j<sheet.getRow(i).getLastCellNum(); j++)
				{
					arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(arr[i][j]);
				}
				
			}
			return arr;
			
		}

}
