package org.javaee.search.binary;

/**
 * 二分查找，while循环实现版本. （必须掌握）
 *
 */
public class BinarySearchLoop {

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
	public int search(int[] nums, int target) {
		// 找不到则返回-1
		if (nums == null) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length - 1; // [重点]
		while (left <= right) { // [重点]
			int middle = left + (right - left) / 2; // 不要用left+right，防止整型值溢出
			// 目标在middle的左方，因此减1
			if (target < nums[middle]) {
				right = middle - 1; // [重点]
			// 目标在middle的右方，因此加1
			} else if (target > nums[middle]) {
				left = middle + 1; // [重点]
			// 如果找到目标了，则返回
			} else {
				return middle;
			}
		}
		
		// 找不到则返回-1
		return -1;
	}
	
	/**
	 * 起始条件：left=0, right=n
	 * 折半计算：left+(right-left)/2 或 (left+right)/2
	 * 更新索引：小于middle则middle，大于middle则middle+1
	 * 结果：找到则返回，否则返回-1
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchV2(int[] nums, int target) {
		// 找不到则返回-1
		if (nums == null) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length; // [***重点]
		while (left < right) { // [***重点]
			int middle = left + (right - left) / 2;
			// 目标在middle的左方，因此减1
			if (target < nums[middle]) {
				right = middle; // [***重点]. 由于left <= right改为left < right，因此这里如果仍为middle-1，可能导致middle-1的位置处理不到
				// 目标在middle的右方，因此加1
			} else if (target > nums[middle]) {
				left = middle + 1; // [重点]
				// 如果找到目标了，则返回
			} else {
				return middle;
			}
		}
		
		// 找不到则返回-1
		return -1;
	}
	
}
