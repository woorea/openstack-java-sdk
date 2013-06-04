package com.woorea.openstack.console.utils;

public class Column {

	public static final int ALIGN_LEFT = -1;
	public static final int ALIGN_RIGHT = 1;

	private String name;
	
	private int size;
	
	private int align;

	public Column(String name, int size, int align) {
		super();
		this.name = name;
		this.size = size;
		this.align = align;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the align
	 */
	public int getAlign() {
		return align;
	}

	/**
	 * @param align the align to set
	 */
	public void setAlign(int align) {
		this.align = align;
	}

	

}
