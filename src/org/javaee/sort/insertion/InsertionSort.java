package org.javaee.sort.insertion;

import java.util.Random;

import org.javaee.util.ArrayUtils;
import org.javaee.util.StopWatch;

/**
 * 插入排序
 * 
 * @author qiuzj
 *
 */
public class InsertionSort {

	public static int[] init(int count) {
		int[] newArray = new int[count];
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			newArray[i] = r.nextInt(100);
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
	public static int[] sort(int[] array) {
		// 初始化：第1个元素有序，从第二个元素开始，往前比较。
		for (int i = 1; i < array.length; i++) {
			int currentItem = array[i];
			int prevIndex = i - 1; // 待插入元素的前一个元素
			while (prevIndex >= 0 && currentItem < array[prevIndex]) { // 比自己大的元素往后移
				array[prevIndex + 1] = array[prevIndex];
				prevIndex--;
			}
			array[prevIndex + 1] = currentItem; // 插入到合适的位置
		}
		return array;
	}
	
	public static void main(String[] args) {
//		ArrayUtils.debug(true);
		
		int[] array = init(10000);
		ArrayUtils.println(array);
		
		StopWatch.start();
		int[] sortedArray = sort(array);
		StopWatch.stopAndOutput();
		ArrayUtils.println(sortedArray);
	}
	
}
