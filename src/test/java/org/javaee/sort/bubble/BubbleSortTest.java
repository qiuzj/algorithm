package org.javaee.sort.bubble;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class BubbleSortTest {

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
			testV1();
			testV2();
			testV3();
		}
	}
	
	@Test
	public void testV1() {
		BubbleSort sort = new BubbleSort();
		long startTime = System.currentTimeMillis();
		int[] newnums = sort.sortV1(nums);
		System.out.println("V1: " + (System.currentTimeMillis() - startTime));
		System.out.println(JSON.toJSONString(newnums));
	}
	
	@Test
	public void testV2() {
		BubbleSort sort = new BubbleSort();
		long startTime = System.currentTimeMillis();
		int[] newnums = sort.sortV2(nums);
		System.out.println("V2: " + (System.currentTimeMillis() - startTime));
		System.out.println(JSON.toJSONString(newnums));
	}
	
	@Test
	public void testV3() {
		BubbleSort sort = new BubbleSort();
		long startTime = System.currentTimeMillis();
		int[] newnums = sort.sortV3(nums);
		System.out.println("V3: " + (System.currentTimeMillis() - startTime));
		System.out.println(JSON.toJSONString(newnums));
	}
	
}
