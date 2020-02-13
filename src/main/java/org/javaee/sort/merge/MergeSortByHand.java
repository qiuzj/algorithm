package org.javaee.sort.merge;

public class MergeSortByHand {

	public int[] sort(int[] nums, int left, int right) {
		if (left >= right) {
			return new int[] {nums[right]};
		}
		// 1.先分区. 类似于折半查找，计算中间位置索引号
		int middle = left + (right - left) / 2;
		// 2.然后左半部分、右半部分分别排序
		// 3.最后合并两个有序数据
		return merge(sort(nums, left, middle), sort(nums, middle + 1, right));
	}

	private int[] merge(int[] nums1, int[] nums2) {
		int[] nums3 = new int[nums1.length + nums2.length];
		int a = 0;
		int b = 0;
		int c = 0;
		while (a < nums1.length && b < nums2.length) {
			if (nums1[a] < nums2[b]) {
				nums3[c++] = nums1[a++];
			} else {
				nums3[c++] = nums2[b++];
			}
		}
		while (a < nums1.length) {
			nums3[c++] = nums1[a++];
		}
		while (b < nums2.length) {
			nums3[c++] = nums2[b++];
		}
		return nums3;
	}

}
