package org.javaee.sort.selection;

public class SelectionSort {

	/**
	 * 从左到右，每次找到一个合适的元素，替换到当前元素.
	 * 对于每一个元素，从后面所有元素中找到最大或最小的值，找完之后再进行一次替换.
	 * 左边不断往后推移，右边不变.
	 * 和冒泡排序一下，只要进行n-1趟排序，每趟比较的次数也比当前待排序元素的数量减1.
	 * 1 2 3
	 * 3 2 1
	 * 
	 * @param nums
	 * @return
	 */
	public int[] sort(int[] nums) {
		// 进行n-1趟，最后1个元素自然完成排序
		for (int i = 0; i < nums.length - 1; i++) {
			// 当前最小值的索引号
			int minIndex = i;
			
			// 从当前元素的下一个元素开始，
			for (int j = i + 1; j < nums.length; j++) {
				// 如果找到更小的值，则更新最小值的索引号
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			
			// 找到更小的元素则交换
			if (minIndex != i) {
				int tmp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = tmp;
			}
		}
		return nums;
	}
	
}
