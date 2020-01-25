package org.javaee.search.binary;

/**
 * 二分查找，递归实现版本. （必须掌握）
 *
 */
public class BinarySearchRecursive {

	/**
	 * 起始条件：left=0, right=n-1
	 * 折半计算：middle=left+(right-left)/2 或 (left+right)/2
	 * 更新索引：小于middle则middle-1，大于middle则middle+1
	 * 结果：找到则返回，否则返回-1
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int middle = left + (right - left) / 2;
		if (nums[middle] == target) {
			return middle;
		}
		if (target < nums[middle]) {
			return search(nums, left, middle - 1, target);
		} else {
			return search(nums, middle + 1, right, target);
		}
	}
	
}
