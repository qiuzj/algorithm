package org.javaee.sort.bubble;

/**
 * 冒泡排序.
 * 从左到右，或从右到左，相邻的元素两两比较，符合条件则进行交换。
 * 
 * 从左边冒到右边，则每次都从索引位置0开始；虫子从右边开始吃糖
 * 因此，右边要设防（小于某个值）；
 * 
 * 从右边冒到左边，则每次都从索引位置n-1开始；虫子从左边开始口香糖
 * 因此，左边要设防（大于某个值）；
 * 
 * @author Binary life
 *
 */
public class BubbleSort {
	
	// 基础版本：假设总的节点数为n，则总共需要处理n-1趟，每趟比较的次数为待排序的节点数m-1。
	
	/**
	 * 从左边冒到右边.
	 * 从左到右，由小到大排序；
	 * 循环n-1趟，每趟比较的次数为待排序的节点数m-1。
	 * "从左向右进行冒泡"，冒到最右边，比较的记录往左收缩；
	 * 每次冒泡的开始，总是从0开始；
	 * 冒泡的趟次，是记录的个数减1（n-1）；
	 * 每次要比较的次数，也是当前要比较的元素个数减1（current-1）；
	 */
	// 每次要比较的次数，也是当前要比较的元素个数减1
	// 从左到右进行冒泡，冒到最右边，右边的值越来越小了
	// j：[0,倒数第2个]。每次冒泡的开始，总是从0开始；
	public int[] sortV1(int[] nums) {
		// 循环n-1趟. n为总的元素个数
		for (int i = 0; i < nums.length - 1; i++) {
			// 循环比较m-1次. m为当前待排序的元素个数.
			// nums.length - i - 1表示待排序元素的最后一个索引号
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}
		return nums;
	}
	
	/**
	 * 从左到右，由小到大排序；
	 * "从右向左进行冒泡"，冒到最左边，比较的记录往右收缩；
	 * 每次冒泡的开始，总是从n-1开始；
	 * 冒泡的趟次，是记录的个数减1（n-1）；
	 * 每次要比较的次数，也是当前要比较的元素个数减1（current-1）；
	 */
	public int[] sortV2(int[] nums) {
		// 循环n-1趟. n为总的元素个数
		for (int i = 0; i < nums.length - 1; i++) {
			// 循环比较m-1次. m为当前待排序的元素个数.
			// i表示待排序元素的第一个索引号
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j - 1] > nums[j]) {
					int tmp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}

	/**
	 * 遇到某趟没有交换位置，则表示已经排好序了，提前退出.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] sortV3(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			boolean exchange = false;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j - 1] > nums[j]) {
					int tmp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = tmp;
					exchange = true;
				}
			}
			// 提前退出
			if (!exchange) {
				break;
			}
		}
		return nums;
	}
	
}
