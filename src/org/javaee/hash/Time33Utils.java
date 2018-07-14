package org.javaee.hash;

public class Time33Utils {

	/**
	 * 乘法运算版本
	 * 
	 * @param value
	 * @return
	 */
	public static int time33V1(String value) {
		int hash = 0;
		for (int i = 0; i < value.length(); i++) {
			hash = 33 * hash + value.charAt(i);
		}
		return hash;
	}
	/**
	 * 位运算版本
	 * 
	 * @param value
	 * @return
	 */
	public static int time33V2(String value) {
		int hash = 0;
		for (int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) + hash) + value.charAt(i);
		}
		return hash;
	}
	/**
	 * 5381版本
	 * 
	 * @param value
	 * @return
	 */
	public static int time33V3(String value) {
		int hash = 5381;
		for (int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) + hash) + value.charAt(i);
		}
		return hash;
	}
	/**
	 * Time31版本
	 * 
	 * @param value
	 * @return
	 */
	public static int time31V1(String value) {
		int hash = 0;
		for (int i = 0; i < value.length(); i++) {
			hash = 31 * hash + value.charAt(i);
		}
		return hash;
	}
	/**
	 * Time31版本
	 * 
	 * @param value
	 * @return
	 */
	public static int time31V2(String value) {
		int hash = 0;
		for (int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) - hash) + value.charAt(i);
		}
		return hash;
	}
	
	public static void main(String[] args) {
		String[] array = {"qiuzhanjia", "中华人民共和国", "qiuzhanjia中华人民共和国"};
		for (String value : array) {
			System.out.print(time33V1(value));
			System.out.print(" ");
			System.out.print(time33V2(value));
			System.out.print(" ");
			System.out.print(time33V3(value));
			
			System.out.print(" ");
			System.out.print(time31V1(value));
			System.out.print(" ");
			System.out.println(time31V2(value));
		}
	}
}
