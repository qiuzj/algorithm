package org.javaee.search.binary;

import org.junit.Test;

public class BinarySearchRecursiveTest {

	@Test
	public void test() {
		int[] nums = {1,2,3,5,7,9,11,15,18,25,50,100};
		int[] targets = {1,2,3,5,7,9,11,15,18,25,50,100,0,101,4,80};
		BinarySearchRecursive bs = new BinarySearchRecursive();
		for (int target : targets) {
			System.out.println(target + " " + bs.search(nums, 0, nums.length - 1, target));
		}
	}
	
	@Test
	public void testLeetcode() {
		int[] nums = {1,3,5,6};
		int[] targets = {5,2,7,0};
		BinarySearchRecursive bs = new BinarySearchRecursive();
		for (int target : targets) {
			System.out.println(target + " " + bs.search(nums, 0, nums.length - 1, target));
		}
	}
	
}
