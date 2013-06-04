package com.woorea.openstack.console.utils;

import java.util.List;

public abstract class TableModel<T> {
	
	protected List<T> data;
	
	public TableModel(List<T> data) {
		this.data = data;
	}
	
	public abstract Column[] getHeaders();

	public final String[][] getRows() {
		String[][] rows = new String[data.size()][];
		for(int i = 0; i < data.size(); i++) {
			rows[i] = getRow(data.get(i));
		}
		return rows;
	}
	
	public abstract String[] getRow(T data);
	
}
