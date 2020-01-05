package org.javaee.heap.example;

import java.util.Arrays;
import java.util.Random;

import org.javaee.heap.MinGenericHeap;
import org.javaee.util.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 实战3：求Top K问题
 * 
 */
public class TopKTest {

	private int[] data;
	
	@Before
	public void init() {
		ArrayUtils.debug(true);
		
		data = new int[10];
		Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(20);
		}
		ArrayUtils.println(data);
	}
	
	@Test
	public void testTopK() {
		int capacity = 3;
		MinGenericHeap<Integer> heap = new MinGenericHeap<>(capacity);
		
		for (int i = 0; i < data.length; i++) {
			// 堆未满
			if (heap.getSize() < capacity) {
				heap.insert(data[i]);
			}
			// 堆已满，且插入元素大于堆顶元素值
			else if (data[i] > heap.peek()) {
				int removeTop = heap.removeTop();
				heap.insert(data[i]);
				System.out.println("remove top: " + removeTop + ", new element: " + data[i]);
			}
			else {
				System.out.println("ignore and no insert: " + data[i]);
			}
		}
		System.out.println(Arrays.toString(heap.getData()));
	}

}
