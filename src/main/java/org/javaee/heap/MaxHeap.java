package org.javaee.heap;

/**
 * 大顶堆
 *
 */
public class MaxHeap extends AbstractHeap{

	public MaxHeap(int capacity) {
		super(capacity);
	}
	
	/**
	 * 插入节点，自下往上堆化
	 * 
	 * @param ele
	 */
	public void insert(int ele) {
		if (size >= capacity)
			return; // 堆满了

		// 1.放到末尾
		data[size] = ele;
		
		/* 2.自下往上堆化 */
		int heapifyIndex = size++;
		int parent = -1;
		// 父节点必须存在，并且父节点比当前节点小
		while ((parent = (heapifyIndex - 1) / 2) >= 0 && data[heapifyIndex] > data[parent]) {
			// 交换节点
			swap(heapifyIndex, parent);
			// 下一个待堆化的节点
			heapifyIndex = parent;
		}
	}

	/**
	 * 自上往下堆化
	 * 
	 * @param heapifySize
	 * @param heapifyIndex 待堆化的节点下标
	 */
	public void siftDownHeapify(int heapifySize, int heapifyIndex) { // 自上往下堆化
		while (true) {
			// 本轮最大的节点的索引号
			int maxIndex = heapifyIndex;
			// 1.计算左右孩子节点的索引号
			int leftChildIndex = heapifyIndex * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			/* 2.在当前待堆化的节点，及其左、右子节点中，找到最大的节点值的索引号 */
			// 存在左节点，并且左节点比父节点大
			if (leftChildIndex < heapifySize && data[heapifyIndex] < data[leftChildIndex])
				maxIndex = leftChildIndex;
			// 存在右节点，并且右节点更大
			if (rightChildIndex < heapifySize && data[maxIndex] < data[rightChildIndex])
				maxIndex = rightChildIndex;
			// 如果待堆化的节点，大于等于左、右子节点，则堆化完成
			if (maxIndex == heapifyIndex)
				break;
			
			// 3.交换节点
			swap(heapifyIndex, maxIndex);
			
			// 4.其中一个孩子节点，成为下一个要堆化的节点
			heapifyIndex = maxIndex;
		}
	}

}
