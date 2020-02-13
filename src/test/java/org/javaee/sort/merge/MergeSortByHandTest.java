package org.javaee.sort.merge;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class MergeSortByHandTest {

//	int[] nums = {4, 6, 8, 3, 5, 7};
//	int[] nums = {4, 3};
//	int[] nums = {3, 4};
//	int[] nums = {5,4,3,2,1};
//	int[] nums = {1,2,3,4,5};
//	int[] nums = {5};
	int[] nums = {5,7,9,1,2,6,4,2,1,4,7,1,9,5,3,6,2,1,0,4,2,3,7,4,1};
	
	@Before
	public void init() {
//		nums = new int[100000];
//		Random r = new Random();
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = r.nextInt(10);
//		}
	}
	
	@Test
	public void test() {
		MergeSortByHand sort = new MergeSortByHand();
		System.out.println(JSON.toJSONString(sort.sort(nums, 0, nums.length - 1)));
	}

	@Test
	public void testV2() {
		MergeSortByHand2 sort = new MergeSortByHand2();
		sort.sort(nums, 0, nums.length - 1);
		System.out.println(JSON.toJSONString(nums));
	}
}
