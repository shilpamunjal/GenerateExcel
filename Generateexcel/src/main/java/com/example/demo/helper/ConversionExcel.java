package com.example.demo.helper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.Model.Category;

public class ConversionExcel {
	public static String SHEET_NAME="category_data";
	public static String[] HEADERS= {
			"Id",
			"Title",
			"Description"
			};
	
	
	public static ByteArrayInputStream datatoExcel(List<Category>list) {
		Workbook workbook=new XSSFWorkbook();
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Sheet sheet=workbook.createSheet(SHEET_NAME);
		Row row=sheet.createRow(0);
		
		for(int i=0;i<HEADERS.length;i++) {
			Cell cell =row.createCell(i);
			cell.setCellValue(HEADERS[i]);
		}
		
		int rowIndex=1;
		for(Category c:list) {
			Row DataRow=sheet.createRow(rowIndex);
			rowIndex++;
			DataRow.createCell(0).setCellValue(c.getCategoryID());
			DataRow.createCell(1).setCellValue(c.getTitle());
			DataRow.createCell(2).setCellValue(c.getDescription());
	
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
	

}
