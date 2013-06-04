package com.woorea.openstack.console.utils;

public class ConsoleUtils {
	
	public static final String RED = "\u001B[31m";
	
	public static final String GREEN = "\u001B[32m";
	
	public static final String YELLOW = "\u001B[33m";
	
	public static final String END = "\u001B[0m";
	
	private StringBuilder sb = new StringBuilder();
	
	public ConsoleUtils append(String text) {
		sb.append(text);
		return this;
	}
	
	public ConsoleUtils red(String text) {
		sb.append(ConsoleUtils.RED).append(text).append(END);
		return this;
	}
	
	public ConsoleUtils green(String text) {
		sb.append(ConsoleUtils.GREEN).append(text).append(END);
		return this;
	}
	
	public ConsoleUtils yellow(String text) {
		sb.append(ConsoleUtils.YELLOW).append(text).append(END);
		return this;
	}
	
	public static void log(String text) {
		System.out.println(new ConsoleUtils().yellow("| ").append(text));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
