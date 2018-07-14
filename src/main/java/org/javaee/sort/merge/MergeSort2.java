package org.javaee.sort.merge;

import java.util.Random;

import org.javaee.util.ArrayUtils;
import org.javaee.util.StopWatch;

/**
 * 归并排序
 * 
 * @author qiuzj
 *
 */
public class MergeSort2 {

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
	public static int[] recursion(int[] array, int first, int end) {
		if (end > first) {
			int middle = (first + end - 1) / 2; // 分解成子问题
			recursion(array, first, middle); // left 递归求解子问题
			recursion(array, middle + 1, end); // right 递归求解子问题
			merge(array, first, middle, end); // merge 合并解
		}
		return array;
	}
	
	private static void merge(int[] array, int first, int middle, int end) {
		int count1 = middle - first + 1; // left，包含middle
		int count2 = end - middle; // right，>middle
		
		// 分别取出左右两个范围的数组元素，不破坏原数据的相对结构数据与引用
		int[] leftArray = new int[count1 + 1];
		int[] rightArray = new int[count2 + 1];
		System.arraycopy(array, first, leftArray, 0, count1);
		System.arraycopy(array, middle + 1, rightArray, 0, count2);
		// 增加哨兵，设置为末尾为最大值，遇到该值相当于将另一个数据的元素全部拿出来，降低循环比较的复杂度
		leftArray[count1] = Integer.MAX_VALUE;
		rightArray[count2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for (int k = first; k <= end; k++) { // 总共end-first+1个元素，始于first，止于end
			if (leftArray[i] < rightArray[j]) { // 左边更小
				array[k] = leftArray[i++];
			} else { // 右边更小
				array[k] = rightArray[j++];
			}
		}
	}

	public static void main(String[] args) {
		ArrayUtils.debug(true);
		
		int[] array = init(20);
		ArrayUtils.println(array);
		
		StopWatch.start();
		int[] sortedArray = recursion(array, 0, array.length - 1);
		StopWatch.stopAndOutput();
		ArrayUtils.println(sortedArray);
	}
	
}
