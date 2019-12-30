package org.javaee.heap;

/**
 * 小顶堆
 *
 */
public class MinGenericHeap<E> extends AbstractGenericHeap<E> {

	public MinGenericHeap() {
		super(16);
	}
	
	public MinGenericHeap(int capacity) {
		super(capacity);
	}
	
	/**
	 * 插入节点，自下往上堆化
	 * 
	 * @param ele
	 */
	public void insert(E ele) {
		if (size >= capacity)
			return; // 堆满了

		// 1.放到末尾
		data[size] = ele;
		
		/* 2.自下往上堆化 */
		int heapifyIndex = size++;
		int parent = -1;
		// 父节点必须存在，并且父节点比当前节点大
		while ((parent = (heapifyIndex - 1) / 2) >= 0 && compare(data[heapifyIndex], data[parent]) < 0) {
			// 交换节点
			swap(heapifyIndex, parent);
			// 下一个待堆化的节点
			heapifyIndex = parent;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (size == 0)
			return null;
		return (E) data[0];
	}

	/**
	 * 自上往下堆化
	 * 
	 * @param heapifySize
	 * @param heapifyIndex 待堆化的节点下标
	 */
	public void siftDownHeapify(int heapifySize, int heapifyIndex) { // 自上往下堆化
		while (true) {
			// 本轮最小的节点的索引号
			int minIndex = heapifyIndex;
			// 1.计算左右孩子节点的索引号
			int leftChildIndex = heapifyIndex * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			/* 2.在当前待堆化的节点，及其左、右子节点中，找到最大的节点值的索引号 */
			// 存在左节点，并且左节点比父节点小
			if (leftChildIndex < heapifySize && compare(data[heapifyIndex], data[leftChildIndex]) > 0)
				minIndex = leftChildIndex;
			// 存在右节点，并且右节点更大
			if (rightChildIndex < heapifySize && compare(data[minIndex], data[rightChildIndex]) > 0)
				minIndex = rightChildIndex;
			// 如果待堆化的节点，大于等于左、右子节点，则堆化完成
			if (minIndex == heapifyIndex)
				break;
			
			// 3.交换节点
			swap(heapifyIndex, minIndex);
			
			// 4.其中一个孩子节点，成为下一个要堆化的节点
			heapifyIndex = minIndex;
		}
	}

}
