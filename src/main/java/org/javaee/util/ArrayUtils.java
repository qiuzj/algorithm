package org.javaee.util;

public class ArrayUtils {

	private static boolean debug;
	
	/**
	 * 设置调试模式，调试模式将会打印日志
	 * 
	 * @param flag
	 */
	public static void debug(boolean flag) {
		debug = flag;
	}
	
	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public static void println(int[] array) {
		if (!debug) return;
		if (array == null || array.length <= 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int obj : array) {
			sb.append(obj).append(",");
		}
		System.out.println(sb.subSequence(0, sb.length() - 1));
	}

	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public static void println(int[] array, int startIndex) {
		if (!debug) return;
		if (array == null || array.length <= 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = startIndex; i < array.length; i++) {
			sb.append(array[i]).append(",");
		}
		System.out.println(sb.subSequence(0, sb.length() - 1));
	}
	
}
