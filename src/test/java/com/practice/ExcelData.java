package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./SDET1.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Object data = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
	
	
		System.out.println(data);
	}

}
