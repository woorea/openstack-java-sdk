package com.woorea.openstack.console.utils;


public class Table {
	
	private StringBuilder sb = new StringBuilder();
	
	private TableModel<?> model;
	
	public Table(TableModel<?> model) {
		this.model = model;
	}
	
	public StringBuilder render() {
		header();
		for(String[] row : model.getRows()) {
			int i = 0;
			for(String column : row) {
				Column columnModel = model.getHeaders()[i];
				sb.append("| ");
				if(column != null) {
					if(Column.ALIGN_RIGHT == columnModel.getAlign()) {
						for(int j = 0; j < columnModel.getSize() - column.length(); j++) {
							sb.append(" ");
						}
					}
					sb.append(column.length() <= columnModel.getSize() ? column : column.substring(0, columnModel.getSize()));
					if(Column.ALIGN_LEFT == columnModel.getAlign()) {
						for(int j = 0; j < columnModel.getSize() - column.length(); j++) {
							sb.append(" ");
						}
					}
				} else {
					for(int k = 0; k < columnModel.getSize(); k++) {
						sb.append(" ");
					}
				}
				sb.append(" ");
				i++;
			}
			sb.append("|\n");
		}
		for(Column c : model.getHeaders()) {
			sb.append("+");
			for(int i = 0; i < c.getSize() + 2; i++) {
				sb.append("-");
			}
		}
		sb.append("+\n");
		return sb;
	}
	
	public void header() {
		for(Column c : model.getHeaders()) {
			sb.append("+");
			for(int i = 0; i < c.getSize() + 2; i++) {
				sb.append("-");
			}
		}
		sb.append("+\n");
		
		for(Column c : model.getHeaders()) {
			sb.append("| ");
			sb.append(c.getName());
			for(int i = 0; i < c.getSize() - c.getName().length(); i++) {
				sb.append(" ");
			}
			sb.append(" ");
		}
		sb.append("|\n");
		
		for(Column c : model.getHeaders()) {
			sb.append("+");
			for(int i = 0; i < c.getSize() + 2; i++) {
				sb.append("-");
			}
		}
		sb.append("+\n");
	}

}
