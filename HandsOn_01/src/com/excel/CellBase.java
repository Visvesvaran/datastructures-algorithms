package com.excel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CellBase {
	
	private int columnIndex;
	private int rowIndex;
	private String value;
	
	
	
	public CellBase() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getColumnIndex() {
		return columnIndex;
	}



	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}



	public int getRowIndex() {
		return rowIndex;
	}



	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}



	public String getValue() {
		return value;
	}
	
	public static CellBase findMatch(String find, List<CellBase> cellBaseList) {
		CellBase cellBase = null;
		for (CellBase cb : cellBaseList) {
			if(find.equalsIgnoreCase(cb.getValue())) {
				cellBase = cb;
				break;
			}
		}
		return cellBase;
	}
	
	public static Map<String, CellBase> getColumnHeaders(List<CellBase> cellBaseList){
		Map<String, CellBase> map = new HashMap<>();
		
		// populates key as column headers
		for (CellBase cb : cellBaseList) {
			if(0 == cb.getRowIndex()) {
				map.put(cb.getValue(), cb);
			}
		}
		
		return map;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	

}
