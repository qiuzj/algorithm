package org.javaee.heap;

/**
 * 堆结构基类. 下标从1开始
 *
 */
public abstract class AbstractZeroBasedHeap {
	protected int[] data; // 数组，从下标1开始存储数据
	protected int capacity; // 堆可以存储的最大数据个数
	protected int size; // 堆中已经存储的数据个数

	public AbstractZeroBasedHeap(int capacity) {
		this.data = new int[capacity + 1];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * 插入节点
	 * 
	 * @param ele
	 */
	public abstract void insert(int ele);

	/**
	 * 移除堆顶
	 * 
	 * @return
	 */
	public int removeHead() {
		int result = -1;
		if (size == 0)
			return result; // 堆中没有数据
		
		// 1.暂存堆顶节点
		result = data[1];
		// 2.删除堆顶节点，并用最后一个节点代替
		data[1] = data[size--];
		// 3.自上往下堆化
		siftDownHeapify(data, size, 1);
		
		return result;
	}

	/**
	 * 建堆.
	 * 对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点。 对下标从 n/2 开始到 1 的数据进行堆化，下标从 n/2+1 到
	 * n 的节点是叶子节点，我们不需要堆化。
	 * 
	 * @param sourceArray
	 * @param sourceSize
	 */
	public void buildHeap(int[] sourceArray, int sourceSize) {
		if (sourceSize > capacity) {
			throw new IllegalArgumentException("sourceSize must lte than capacity");
		}
		for (int i = sourceSize / 2; i >= 1; --i) {
			siftDownHeapify(sourceArray, sourceSize, i);
		}
		System.arraycopy(sourceArray, 0, data, 0, sourceSize);
		this.size = sourceSize;
	}

	/**
	 * 堆排序.
	 * n表示数据的个数，数组a中的数据从下标1到n的位置。
	 * 
	 * @param data
	 * @param size
	 */
	public void sort(int[] data, int size) {
		// 1.建堆
		buildHeap(data, size);
		// 2.排序
		int k = size;
		while (k > 1) {
			swap(data, 1, k); // 2.1 堆顶节点（第1个）与第k个节点互换，第k个节点已排好序。
			siftDownHeapify(data, --k, 1); // 2.2 对堆顶节点进行堆化，向下堆化至k-1的位置后结束。
		}
	}

	/**
	 * 交换索引为i和j的元素位置
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	protected void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * 将索引index对应的节点向下堆化
	 * 
	 * @param data 存储堆的数组
	 * @param heapifySize 从堆顶开始，到堆化结束的节点的元素个数
	 * @param index 进行堆化的节点索引
	 */
	protected abstract void siftDownHeapify(int[] data, int heapifySize, int index);

}