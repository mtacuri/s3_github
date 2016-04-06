package com.cjava.peru.s03_ejemplo04.util;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cjava.peru.s03_ejemplo04.dao.ContactDAO;
import com.cjava.peru.s03_ejemplo04.model.Contact;

public class Excel{
	
	public void leer()throws IOException{
	
	try {
	String filename = "d:workbook.xlsx";
	FileInputStream fis = null;
    fis = new FileInputStream(filename);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	XSSFRow row;
	XSSFCell cell;

	int rows; 
	rows = sheet.getPhysicalNumberOfRows();
	int cols = 0; 
	int tmp = 0;
	for(int i = 0; i < 10 || i < rows; i++) {
	row = sheet.getRow(i);
	if(row != null) {			
	tmp = sheet.getRow(i).getPhysicalNumberOfCells();	
	if(tmp > cols) cols = tmp;		
	}
	}
	for(int r = 0; r < rows; r++) {
		Contact c = new Contact();
		//String s = c.toString () ;
		//int x=Integer.parseInt(s);
		ContactDAO contactDAO=new ContactDAO();
		row = sheet.getRow(r);
		if(row != null) {
			System.out.print("\n" + r + "\t");
			
		//int resultado  = Integer.valueOf(c);

			for(int x1 = 0; x1 < cols; x1++) {
				cell = row.getCell((short)x1);	
						
				//if(cell.getCellType()==cell.CELL_TYPE_STRING){

				if (cell != null) {
					
					switch (x1){
						//columna firstname
						case 0:	c.setFirstname(cell.getRichStringCellValue().getString());
						case 1: c.setLastname(cell.getRichStringCellValue().getString()); 	
						case 2: 
						if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
							c.setPhone(cell.getNumericCellValue()); break;
						}
						case 3: c.setEmail(cell.getRichStringCellValue().getString());
						case 4: c.setCountry(cell.getRichStringCellValue().getString());
					}	
				}
				}		
		}contactDAO.create(c);
	}
	}   
	catch(IOException ex)  {      
		System.out.println("Error al leer el fichero.");        
	}     
	}
	}