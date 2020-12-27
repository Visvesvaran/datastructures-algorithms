package com.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadSpecificColumn {
	private static final String CSV_FILE_PATH = "C:\\Users\\visve\\eclipse-workspace\\HandsOn_01\\csv\\02.xls";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
        
      //test file is located in your project path         
        FileInputStream fileIn = new FileInputStream(CSV_FILE_PATH);
        //read file 
        POIFSFileSystem fs = new POIFSFileSystem(fileIn); 
        HSSFWorkbook filename = new HSSFWorkbook(fs);
        //open sheet 0 which is first sheet of your worksheet
        HSSFSheet sheet = filename.getSheetAt(0);

        //we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
        String columnWanted = "FirstName";
        Integer columnNo = null;
        //output all not null values to the list
        List<Cell> cells = new ArrayList<Cell>();
        Map<Integer, Cell> kvp = new HashMap<>();

        Row firstRow = sheet.getRow(0);

        for(Cell cell:firstRow){
            if (cell.getStringCellValue().equals(columnWanted)){
                columnNo = cell.getColumnIndex();
            }
        }


        if (columnNo != null){
        for (Row row : sheet) {
           Cell c = row.getCell(columnNo);
           if (c == null) {
              // Nothing in the cell in this row, skip it
           } else {
              cells.add(c);
              kvp.put(c.getRowIndex(), c);
           }
        }
        }else{
            System.out.println("could not find column " + columnWanted + " in first row of " + fileIn.toString());
        }
        
        System.out.println(cells);
        
        System.out.println(kvp.toString());
	}	

}
