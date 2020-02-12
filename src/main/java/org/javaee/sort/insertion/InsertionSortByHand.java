package org.javaee.sort.insertion;

/**
 * 容易出错的点：
 * 1.一定要用哨兵，因为前面的元素往后移会覆盖当前值；
 * 2.找到位置后，在循环外进行赋值；不要在循环内的break前处理，因为里面不一定会被执行。
 * 
 * @author Binary life
 *
 */
public class InsertionSortByHand {

	/**
	 * 左边为有序部分，右边为待排序部分.
	 * 初始状态，第1个元素为有序；
	 * 从第2个元素开始，往前比较，如果与前一个元素比较发现已提排好序则跳过本次排序；
	 * 执行的趟次为n-1；
	 * 每个元素比较的次数，为在其之前的元素个数。
	 * 
	 * @param nums
	 * @return
	 */
	// 如果已完成排序则跳过本次处理
	public int[] sort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		// 对第2到最后一个元素进行排序
		for (int i = 1; i < nums.length; i++) {
			int current = nums[i]; // 哨兵很重要啊
			int j = i - 1;
			for (; j >= 0; j--) {
				if (nums[j] > current) { // current不能用nums[i]，因为它的值可能已经被改变了
					nums[j + 1] = nums[j]; // 重点是注意这里，往后移以后nums[i]会被覆盖
				} else {
					break;
				}
			}
			nums[j + 1] = current; // current不能用nums[i]，因为它的值可能已经被改变了
		}
		return nums;
	}
	
	// 再练习一遍
	public int[] sortV2(int[] nums) {
		// 从第2个开始排序，共n-1个
		for (int i = 1; i < nums.length; i++) {
			// 哨兵很重要啊，因为原位置的值在移动后会被覆盖掉
			int current = nums[i];
			// 与前一个元素开始比较
			int j = i - 1;
			// 比较范围：[i-1,0]
			for (; j >= 0; j--) {
				if (nums[j] > current) {
					nums[j + 1] = nums[j];
				} else {
					break;
				}
			}
			nums[j + 1] = current;
		}
		return nums;
	}
	
}
