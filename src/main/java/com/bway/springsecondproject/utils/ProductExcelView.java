package com.bway.springsecondproject.utils;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.bway.springsecondproject.model.Products;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=product.xls");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) model.get("pList");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("PRODUCTS");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("PROD_NAME");
		row.createCell(2).setCellValue("PRICE");
		row.createCell(3).setCellValue("WEIGHT");
		row.createCell(4).setCellValue("DESCRIPTION");
	}
	
	private void setBody(Sheet sheet, List<Products> list) {
		int rowNum = 1;
		for(Products spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getProd_name());
			row.createCell(2).setCellValue(spec.getPrice());
			row.createCell(3).setCellValue(spec.getWeight());
			row.createCell(4).setCellValue(spec.getDescription());
		}
	}

}
