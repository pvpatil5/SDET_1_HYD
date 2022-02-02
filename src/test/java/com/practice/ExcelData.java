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

		int lastrowmmuber = wb.getSheet("Sheet3").getLastRowNum();


		for (int i = 1; i <= lastrowmmuber; i++) 
		{
			int salary=(int) wb.getSheet("Sheet3").getRow(i).getCell(2).getNumericCellValue();
			
			if(salary>50000) 
			{
				System.out.println(wb.getSheet("Sheet3").getRow(i).getCell(1).getStringCellValue()+" "
						+ salary);
			}
		}
	}

}
