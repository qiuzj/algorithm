package org.javaee.sort.selection;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class SelectionSortTest {

	int[][] numsAll = {
			{4, 6, 8, 3, 5, 7},
			{5,4,3,2,1},
			{5},
			{5,7,9,1,2,6,4,2,1,4,7,1,9,5,3,6,2,1,0,4,2,3,7,4,1}
			};
	int[] nums;
	
	@Before
	public void init() {
//		nums = new int[100000];
//		Random r = new Random();
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = r.nextInt(10);
//		}
	}
	
	@Test
	public void testAll() {
		for (int[] item : numsAll) {
			this.nums = item;
			test();
		}
	}
	
	@Test
	public void test() {
		SelectionSort sort = new SelectionSort();
		int[] newnums = sort.sort(nums);
		System.out.println(JSON.toJSONString(newnums));
	}
	
}
