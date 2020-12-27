package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadSpecificColumn2 {
	private static final String CSV_FILE_PATH = "C:\\Users\\visve\\eclipse-workspace\\HandsOn_01\\csv\\03.xls";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		HSSFSheet sheet = getSheet();
		
		Row firstRowColumnHeaders = sheet.getRow(0);
		
		List<CellBase> cbList = new ArrayList<>();
		
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				Cell c = r.getCell(j);
		           if (c == null) {
		              // Nothing in the cell in this row, skip it
		           } else {
		              CellBase cb = new CellBase();
		              cb.setRowIndex(c.getRowIndex());
		              cb.setColumnIndex(c.getColumnIndex());
		              cb.setValue(c.toString());
		              cbList.add(cb);
		           }				
			}
		}
		
		for (CellBase cellBase : cbList) {
			display(cellBase);
		}
		
		Map<String, CellBase> colHeaderMap = CellBase.getColumnHeaders(cbList);
		System.out.println(colHeaderMap.values());
		
		// find python
		String python = "c";
		CellBase pythonCellBase = CellBase.findMatch(python, cbList);
		display(pythonCellBase);
		
		// find phone number of python
		String phone = "phone";
		CellBase phoneCellBase = CellBase.findMatch(phone, cbList);
		display(phoneCellBase);
		
		CellBase pythonPhone = new CellBase();
		for (CellBase cellBase : cbList) {
			if(phoneCellBase.getColumnIndex() == cellBase.getColumnIndex()
					&& pythonCellBase.getRowIndex() == cellBase.getRowIndex()) {
				pythonPhone = cellBase;
				System.out.println("Phone number of "+pythonCellBase.getValue()+" is "+pythonPhone.getValue());
				break;
			}
		}
		display(pythonPhone);

        
	}

	/**
	 * @param cellBase
	 */
	private static void display(CellBase cellBase) {
		System.out.println(cellBase.getRowIndex());
		System.out.println(cellBase.getColumnIndex());
		System.out.println(cellBase.getValue());
	}
	
	private static HSSFSheet getSheet() throws FileNotFoundException, IOException {
		//test file is located in your project path         
        FileInputStream fileIn = new FileInputStream(CSV_FILE_PATH);
        //read file 
        POIFSFileSystem fs = new POIFSFileSystem(fileIn); 
        HSSFWorkbook filename = new HSSFWorkbook(fs);
        //open sheet 0 which is first sheet of your worksheet
        HSSFSheet sheet = filename.getSheetAt(0);
        return sheet;
        
	}
	
}
