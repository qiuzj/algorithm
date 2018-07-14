package org.javaee.util;

/**
 * 秒表
 * 
 * @author qiuzj
 *
 */
public class StopWatch {

	private static long startTime;
	
	/**
	 * 开始计时
	 */
	public static void start() {
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * 停止计时并打印日志
	 */
	public static void stopAndOutput() {
		System.out.println("time cost " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
}
