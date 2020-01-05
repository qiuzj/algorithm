package org.javaee.heap.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javaee.heap.MaxGenericHeap;
import org.javaee.heap.MinGenericHeap;
import org.junit.Test;

/**
 * 实战4：计算中位数或百分位数
 *
 */
public class PercentileAndMedianTest {

	@Test
	public void testPercentile() {
		int initialCapacity = 100;
		
		// 生成顺序的n个数
		List<Integer> orderList = new ArrayList<>(initialCapacity);
		for (int i = 1; i <= initialCapacity; i++) {
			orderList.add(i);
		}
		System.out.print("set：");
		orderList.forEach(e -> {
			System.out.print(e + ",");
		});
		System.out.println();

		// 随机化到一个新的List
		List<Integer> randomList = new ArrayList<>(initialCapacity);
		Random random = new Random();
		while (orderList.size() > 0) {
			int nextInt = random.nextInt(orderList.size());
			int val = orderList.remove(nextInt);
			randomList.add(val);
//			System.out.println("remove index: " + nextInt + ", val: " + val);
		}
		System.out.print("list：");
		randomList.forEach(e -> {
			System.out.print(e + ",");
		});
		
		// 创建大顶堆放和小顶堆
		MaxGenericHeap<Integer> maxHeap = new MaxGenericHeap<>(initialCapacity);
		MinGenericHeap<Integer> minHeap = new MinGenericHeap<>(initialCapacity);
		// 设置占比
		double maxRatio = 0.83D;
		double minRatio = 1.0D - maxRatio;
		
		System.out.println("\n");
		randomList.forEach(e -> {
			// 大顶堆L为空，插入大顶堆L
			if (maxHeap.getSize() == 0) {
				System.out.println("insert into maxHeap: " + e);
				maxHeap.insert(e);
			// 插入的数据比大顶堆L的堆顶大
			} else if (e > maxHeap.peek()) {
				System.out.println("insert into minHeap: " + e);
				// 插入小顶堆S
				minHeap.insert(e);
				// 如果占比>m%，则取出堆顶并插入到大顶堆L
				int totalSize = minHeap.getSize() + maxHeap.getSize();
				int ratioSize = (int) Math.floor(totalSize * minRatio);
				if (minHeap.getSize() > ratioSize) {
					Integer removeTop = minHeap.removeTop();
					maxHeap.insert(removeTop);
//					System.out.println(String.format("ratio:%s > minRatio:%s, removeTop:%s", ratio, minRatio, removeTop));
					System.out.println(String.format("minRatio:%s, totalSize:%s, ratioSize:%s, removeTop:%s", minRatio, totalSize, ratioSize, removeTop));
				}
			// 插入的数据小于等于大顶堆L的堆顶
			} else {
				System.out.println("insert into maxHeap: " + e);
				// 插入大顶堆L
				maxHeap.insert(e);
				// 如果占比>n%，则取出堆顶并插入到小顶堆S
				int totalSize = minHeap.getSize() + maxHeap.getSize();
				int ratioSize = (int) Math.floor(totalSize * maxRatio);
				if (maxHeap.getSize() > ratioSize) {
					Integer removeTop = maxHeap.removeTop();
					minHeap.insert(removeTop);
//					System.out.println(String.format("ratio:%s > maxRatio:%s, removeTop:%s", ratio, maxRatio, removeTop));
					System.out.println(String.format("maxRatio:%s, totalSize:%s, ratioSize:%s, removeTop:%s", maxRatio, totalSize, ratioSize, removeTop));
				}
			}
		});
		
		System.out.println("\nfind it：" + maxHeap.peek());
		System.out.println("maxHeap size：" + maxHeap.getSize());
		while (maxHeap.getSize() > 0) {
			System.out.print(maxHeap.removeTop() + ",");
		}
		System.out.println("\nminHeap size：" + minHeap.getSize());
		while (minHeap.getSize() > 0) {
			System.out.print(minHeap.removeTop() + ",");
		}
	}
	
}
