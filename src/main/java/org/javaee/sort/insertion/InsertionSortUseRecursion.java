package org.javaee.sort.insertion;

import java.util.Random;

import org.javaee.util.ArrayUtils;
import org.javaee.util.StopWatch;

/**
 * 插入排序递归版本
 * 
 * @author qiuzj
 *
 */
public class InsertionSortUseRecursion {

	public static int[] init(int count) {
		int[] newArray = new int[count];
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			newArray[i] = r.nextInt(1000);
		}
		return newArray;
	}
	
	/**
	 * <pre>
	 * 循环不变式：
	 * 初始化
	 * 保持
	 * 终止
	 * 类比：扑克牌逐张插入
	 * </pre>
	 * 
	 * @param array
	 * @return
	 */
	public static int[] recursion(int[] array, int size) {
		if (size > 1) {
			recursion(array, size - 1);
			int lastItem = array[size - 1];
			int prevIndex = size - 2;
			while (prevIndex >= 0 && array[prevIndex] > lastItem) {
				array[prevIndex + 1] = array[prevIndex--];
			}
			array[prevIndex + 1] = lastItem;
		}
		return array;
	}
	
	public static void main(String[] args) {
		ArrayUtils.debug(true);
		
		int[] array = init(20); // 小心java.lang.StackOverflowError：-Xss20m
		ArrayUtils.println(array);
		
		StopWatch.start();
		int[] sortedArray = recursion(array, array.length);
		StopWatch.stopAndOutput();
		ArrayUtils.println(sortedArray);
	}
	
}
