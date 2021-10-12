package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDatafromExcel (int row,int cell,String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./SDET1.xlsx");

		Workbook wb=WorkbookFactory.create(fis);

		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();

		return  data;
	}
}
