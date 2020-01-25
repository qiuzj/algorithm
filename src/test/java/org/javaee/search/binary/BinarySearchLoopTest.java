package org.javaee.search.binary;

import org.junit.Test;

public class BinarySearchLoopTest {

	@Test
	public void test() {
		int[] nums = {1,2,3,5,7,9,11,15,18,25,50,100};
		int[] targets = {1,2,3,5,7,9,11,15,18,25,50,100,0,101,4,80};
		BinarySearchLoop bs = new BinarySearchLoop();
		for (int target : targets) {
			System.out.println(target + " " + bs.search(nums, target));
		}
	}

	@Test
	public void testV2() {
		int[] nums = {1,2,3,5,7,9,11,15,18,25,50,100};
		int[] targets = {1,2,3,5,7,9,11,15,18,25,50,100,0,101,4,80};
		BinarySearchLoop bs = new BinarySearchLoop();
		for (int target : targets) {
			System.out.println(target + " " + bs.searchV2(nums, target));
		}
	}
	
	@Test
	public void testLeetcode() {
		int[] nums = {1,3,5,6};
		int[] targets = {5,2,7,0};
		BinarySearchLoop bs = new BinarySearchLoop();
		for (int target : targets) {
			System.out.println(target + " " + bs.search(nums, target));
		}
	}
	
	@Test
	public void testLeetcodeV2() {
		int[] nums = {1,3,5,6};
		int[] targets = {5,2,7,0};
		BinarySearchLoop bs = new BinarySearchLoop();
		for (int target : targets) {
			System.out.println(target + " " + bs.searchV2(nums, target));
		}
	}
	
}
