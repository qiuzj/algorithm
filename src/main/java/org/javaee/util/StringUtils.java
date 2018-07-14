package org.javaee.util;

public class StringUtils {

	/**
	 * 打印字符串，在前面添加n个空格
	 * 
	 * @param str
	 * @param prevBlanks
	 */
	public static void print(String str, int prevBlanks) {
		for (int i = 0; i < prevBlanks; i++) {
			System.out.print("\t");
		}
		System.out.println(str);
	}
	
}
