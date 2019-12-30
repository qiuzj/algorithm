package org.javaee.heap;

import org.javaee.util.ArrayUtils;
import org.junit.Test;

public class MaxHeapTest {

	@Test
	public void testBuildHeap() {
		ArrayUtils.debug(true);

		int[] a = {5,6,2,7,9,3,10,2,54,38,91,34,62,58};
		System.out.println("原始数组");
		// 5,6,2,7,9,3,10,2,54,38,91,34,62,58
		ArrayUtils.println(a);

		MaxHeap heap = new MaxHeap(a.length);
		heap.buildHeap(a);
		System.out.println("建堆结果");
		// 91,54,62,7,38,34,58,2,5,6,9,2,3,10
		ArrayUtils.println(heap.getData());
	}
	
	@Test
	public void testBuildHeapAndSort() {
		ArrayUtils.debug(true);
		
		int[] a = {5,6,2,7,9,3,10,2,54,38,91,34,62,58};
		System.out.println("原始数组");
		// 5,6,2,7,9,3,10,2,54,38,91,34,62,58
		ArrayUtils.println(a);
		
		MaxHeap heap = new MaxHeap(a.length);
		heap.sort(a);
		System.out.println("堆排序结果");
		// 2,2,3,5,6,7,9,10,34,38,54,58,62,91
		ArrayUtils.println(heap.getData());
	}

	@Test
	public void testRemoveTopAndInsert() {
		ArrayUtils.debug(true);

		int[] a = {5,6,2,7,9,3,10,2,54,38,91,34,62,58};
		System.out.println("原始数组");
		ArrayUtils.println(a);

		MaxHeap heap = new MaxHeap(a.length);
		heap.buildHeap(a);
		System.out.println("建堆结果");
		ArrayUtils.println(heap.getData());
		
		System.out.println();
		while (heap.getSize() > 0) {
			System.out.println("移除堆顶：" + heap.removeTop());
			ArrayUtils.println(heap.getData());
		}
		
		System.out.println();
		for (int item : a) {
			heap.insert(item);
			System.out.println("插入元素：" + item);
			ArrayUtils.println(heap.getData());
		}
		
		heap.sort();
		System.out.println("堆排序结果");
		// 2,2,3,5,6,7,9,10,34,38,54,58,62,91
		ArrayUtils.println(heap.getData());
	}
}
