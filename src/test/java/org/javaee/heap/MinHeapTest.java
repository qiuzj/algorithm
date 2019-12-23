package org.javaee.heap;

import org.javaee.util.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

	private int[] sourceArray;
	
	@Before
	public void init() {
		ArrayUtils.debug(true);
		
		sourceArray = new int[]{5,6,2,7,9,3,10,2,54,38,91,34,62,58};
		System.out.println("原始数组");
		// 5,6,2,7,9,3,10,2,54,38,91,34,62,58
		ArrayUtils.println(sourceArray);
	}
	
	@Test
	public void testBuildHeap() {
		MinHeap heap = new MinHeap(sourceArray.length);
		heap.buildHeap(sourceArray);
		System.out.println("建堆结果");
		// 2,5,2,6,9,3,10,7,54,38,91,34,62,58
		ArrayUtils.println(heap.getData());
	}
	
	@Test
	public void testBuildHeapAndSort() {
		MinHeap heap = new MinHeap(sourceArray.length);
		heap.sort(sourceArray);
		System.out.println("堆排序结果");
		// 91,62,58,54,38,34,10,9,7,6,5,3,2,2
		ArrayUtils.println(heap.getData());
	}

	@Test
	public void testRemoveTopAndInsert() {
		MinHeap heap = new MinHeap(sourceArray.length);
		heap.buildHeap(sourceArray);
		System.out.println("建堆结果");
		ArrayUtils.println(heap.getData());
		
		System.out.println();
		while (heap.getSize() > 0) {
			System.out.println("移除堆顶：" + heap.removeTop());
			ArrayUtils.println(heap.getData());
		}
		
		System.out.println();
		for (int item : sourceArray) {
			heap.insert(item);
			System.out.println("插入元素：" + item);
			ArrayUtils.println(heap.getData());
		}
		
		heap.sort();
		System.out.println("堆排序结果");
		// 91,62,58,54,38,34,10,9,7,6,5,3,2,2
		ArrayUtils.println(heap.getData());
	}
}
