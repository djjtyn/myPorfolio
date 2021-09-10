//This class will ensure a new row will be inserted in the html pages after the correct number of bootstrap columns 

package com.porfolio.helpers;

public class RowMonitor {
	
	private short columnCount = 0;
	
	public short incrementColumnCount() {
		columnCount++;
		return columnCount;
	}
	
	public short getColumnCount() {
		return this.columnCount;
	}
}
