package org.javaee.heap;

/**
 * 堆结构. 下标从1开始
 *
 */
public class Heap {
	private int[] array; // 数组，从下标1开始存储数据
	private int capacity; // 堆可以存储的最大数据个数
	private int size; // 堆中已经存储的数据个数

	public Heap(int capacity) {
		this.array = new int[capacity + 1];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * 大顶堆，自下往上堆化
	 * 
	 * @param data
	 */
	public void insertSiftUp(int data) {
		if (size >= capacity)
			return; // 堆满了

		++size;
		array[size] = data; // 放到末尾
		int i = size;
		while (i / 2 > 0 && array[i] > array[i / 2]) { // 自下往上堆化
			swap(array, i, i / 2); // swap()函数作用：交换下标为i和i/2的两个元素
			i = i / 2;
		}
	}

	public void removeMax() {
		if (size == 0)
			return; // 堆中没有数据
		// 删除第1个节点，用最后一个节点代替
		array[1] = array[size];
		// 大小减1
		--size;
		// 大顶堆，自上往下堆化
		siftDownHeapify(array, size, 1);
	}

	/**
	 * 大顶堆，自上往下堆化
	 * 
	 * @param array
	 * @param n
	 * @param toMoveIndex
	 *            待堆化的节点下标
	 */
	private void siftDownHeapify(int[] array, int n, int toMoveIndex) { // 自上往下堆化
		while (true) {
			int maxPos = toMoveIndex;
			// 存在左节点，并且左节点比父节点大
			if (toMoveIndex * 2 <= n && array[toMoveIndex] < array[toMoveIndex * 2])
				maxPos = toMoveIndex * 2;
			// 存在右节点，并且右节点更大
			if (toMoveIndex * 2 + 1 <= n && array[maxPos] < array[toMoveIndex * 2 + 1])
				maxPos = toMoveIndex * 2 + 1;
			// 如果待堆化的节点i，大于等于左、右子节点，则堆化完成
			if (maxPos == toMoveIndex)
				break;
			// 交换节点
			swap(array, toMoveIndex, maxPos);
			// 下一个要堆化的节点
			toMoveIndex = maxPos;
		}
	}

	/**
	 * 建堆. 对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点。 对下标从 n/2 开始到 1 的数据进行堆化，下标从 n/2+1 到
	 * n 的节点是叶子节点，我们不需要堆化。
	 * 
	 * @param a
	 * @param n
	 */
	public void buildHeap(int[] a, int n) {
		for (int i = n / 2; i >= 1; --i) {
			siftDownHeapify(a, n, i);
		}
	}

	/**
	 * 从小到大排序.
	 * n表示数据的个数，数组a中的数据从下标1到n的位置。
	 * 
	 * @param a
	 * @param n
	 */
	public void sort(int[] a, int n) {
		buildHeap(a, n);
		int k = n;
		while (k > 1) {
			swap(a, 1, k);
			--k;
			siftDownHeapify(a, k, 1);
		}
	}

	/**
	 * 交换i和j的位置
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}