package org.javaee.search.binary;

/**
 * 二分查找递归
 * 
 * @author qiuzj
 *
 */
public class BinarySearch {

	public static int search(int[] array, int startIndex, int endIndex, int item) {
		int middleIndex = (endIndex + startIndex) / 2;
		if (middleIndex == startIndex && middleIndex == endIndex) {
			return (item == array[middleIndex]) ? middleIndex : -1;
		} else if (item < array[middleIndex]) {
			return search(array, startIndex, middleIndex, item);
		} else if (item > array[middleIndex]) {
			return search(array, middleIndex + 1, endIndex, item);
		}
		return middleIndex;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,5,7,11,13,17,19};
		for (int i = 0; i < 20; i++) {
			int index = search(array, 0, array.length - 1, i);
			System.out.println(i + ":" + index);
		}
	}
	
}
