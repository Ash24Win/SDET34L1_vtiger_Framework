package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.sdet34l1.genericUtility.GeneralExcelUtility;

public class CopyFetchDataFromExcel2 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
	
		String data = GeneralExcelUtility.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(data);
		
	}
}
