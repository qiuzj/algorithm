package org.javaee.search.binary;

/**
 * 二分查找递归
 * 
 * @author qiuzj
 *
 */
public class BinarySearch3 {

	public static int search(int[] array, int startIndex, int endIndex, int item) {
		if (startIndex == endIndex) {
			return (item == array[startIndex]) ? startIndex : -1;
		}
		int middleIndex = (endIndex + startIndex - 1) / 2;
		if (item < array[middleIndex]) {
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
