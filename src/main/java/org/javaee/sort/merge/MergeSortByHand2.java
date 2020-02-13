package org.javaee.sort.merge;

public class MergeSortByHand2 {

	public void sort(int[] nums, int left, int right) {
		// 【重点】判断
		if (left < right) {
			int middle = left + (right - left) / 2;
			sort(nums, left, middle); // 【重点】middle
			sort(nums, middle + 1, right); // 【重点】middle+1
			merge(nums, left, middle, right);
		}
	}

	private void merge(int[] nums, int left, int middle, int right) {
		int[] tmp = new int[right - left + 1]; // 【重点】长度计算
		
		int p1 = left;
		int p2 = middle + 1;
		int p3 = 0;
		
		// 【重点】<=
		while (p1 <= middle && p2 <= right) {
			if (nums[p1] < nums[p2]) {
				tmp[p3++] = nums[p1++];
			} else {
				tmp[p3++] = nums[p2++];
			}
		}
		
		while (p1 <= middle) {
			tmp[p3++] = nums[p1++];
		}
		
		while (p2 <= right) {
			tmp[p3++] = nums[p2++];
		}
		
		// 【重点】记得拷贝回原数组
		System.arraycopy(tmp, 0, nums, left, tmp.length);
	}

}
