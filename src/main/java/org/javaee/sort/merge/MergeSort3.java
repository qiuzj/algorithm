package org.javaee.sort.merge;

import java.util.Random;

import org.javaee.util.ArrayUtils;

/**
 * 归并排序. 徒手写的归并，很一般
 * 
 * @author qiuzj
 *
 */
public class MergeSort3 {

	public static int[] init(int count) {
		int[] newArray = new int[count];
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			newArray[i] = r.nextInt(100);
		}
		return newArray;
	}

	public static int[] mergeSort(int[] arr, int l, int r) {
		if (l == r)
			return new int[]{arr[l]};
		int m = (l + r) / 2;
		if (m == l)
			return new int[]{arr[l]};
		int[] leftArr = mergeSort(arr, l, m);
		int[] rightArr = mergeSort(arr, m, r);
		return mergeData(leftArr, rightArr);
	}

	public static int[] mergeData(int[] leftArr, int[] rightArr) {
		int length = leftArr.length + rightArr.length;
		int[] newArr = new int[length];
		int sl = 0;
		int sr = 0;
		int i = 0;
		while (sl < leftArr.length && sr < rightArr.length) {
			if (leftArr[sl] < rightArr[sr]) {
				newArr[i++] = leftArr[sl++];
			} else {
				newArr[i++] = rightArr[sr++];
			}
		}
		while (sl < leftArr.length) {
			newArr[i++] = leftArr[sl++];
		}
		while (sr < rightArr.length) {
			newArr[i++] = rightArr[sr++];
		}
		return newArr;
	}

	public static void main(String[] args) {
		ArrayUtils.debug(true);

		int[] array = init(20);
		ArrayUtils.println(array);
		
		int[] sortedArray = mergeSort(array, 0, array.length);
		ArrayUtils.println(sortedArray);
	}

}
