package org.javaee.sort.quick;

public class QuickSort {

	public int[] sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	/**
	 * 1.第一个重点是写出递推公式：
	 * qsort(nums,left,right)=qsort(nums,left,middle-1)+middle+qsort(nums,middle+1,right);
	 * 终止条件：
	 * left>=right
	 * 2.第二个重点是：找到分区点middle，其实分区就是核心的方法了
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 */
	private void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		// 核心方法
		int middle = partition(nums, left, right);
		// 左区排序
		quickSort(nums, left, middle - 1);
		// 右区排序
		quickSort(nums, middle + 1, right);
	}

	private int partition(int[] nums, int left, int right) {
		// 哨兵，分区点
		int guard = nums[left];
		// true：正向遍历，false：倒序遍历
		boolean flag = false;
		
		while (left < right) {
			// 倒序
			if (!flag) {
				// 比哨兵小，则移到左边
				if (nums[right] < guard) {
					nums[left++] = nums[right];
					flag = true;
				} else {
					// 否则指针左移
					right--;
				}
			// 正序
			} else {
				// 比哨兵大，则移到右边
				if (nums[left] > guard) {
					nums[right--] = nums[left];
					flag = false;
				} else {
					// 否则指针右移
					left++;
				}
			}
		}
		
		// 更新为guard
		// 将找到的位置返回
		nums[left] = guard;
		
		return left;
	}
	
}
