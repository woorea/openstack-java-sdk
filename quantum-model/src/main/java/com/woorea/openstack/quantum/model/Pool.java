package com.woorea.openstack.quantum.model;

import java.io.Serializable;

public class Pool implements Serializable{
	
	private String start;
	private String end;
	
	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Allocation_pool [start=" + start + ", end=" + end + "]";
	}
	
}
