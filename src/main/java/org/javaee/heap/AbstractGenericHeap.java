package org.javaee.heap;

/**
 * 堆结构基类. 下标从1开始
 *
 */
public abstract class AbstractGenericHeap<E> {
	protected Object[] data; // 存储堆的数组，从下标0开始存储数据
	protected int capacity; // 堆可以存储的最大数据个数
	protected int size; // 堆中已经存储的数据个数

	public AbstractGenericHeap(int capacity) {
		this.data = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * 插入节点
	 * 
	 * @param ele
	 */
	public abstract void insert(E ele);

	/**
	 * 移除堆顶
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E removeTop() {
		E result = null;
		if (size == 0)
			return result; // 堆中没有数据
		
		// 1.暂存堆顶节点
		result = (E) data[0];
		// 2.删除堆顶节点，并用最后一个节点代替
		data[0] = data[--size];
		// 3.自上往下堆化
		siftDownHeapify(size, 0);
		
		return result;
	}
	
	/**
	 * 获得堆顶节点，但不删除节点
	 * 
	 * @return
	 */
	public abstract E peek();

	/**
	 * 建堆.（实际处理时，下标从0开始）
	 * 对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点。 对下标从 n/2 开始到 1 的数据进行堆化，下标从 n/2+1 到
	 * n 的节点是叶子节点，我们不需要堆化。
	 * 
	 * @param source
	 * @param sourceSize
	 */
	public void buildHeap(Object[] source) {
		if (source.length > capacity) {
			throw new IllegalArgumentException("sourceSize must lte than capacity");
		}
		
		// 1.复制数组
		System.arraycopy(source, 0, data, 0, source.length);
		size = source.length;
		
		// 2.从最后一个非叶子节点开始，往前逐个向下堆化，完成建堆
		for (int i = (size - 1) / 2; i >= 0; --i) {
			siftDownHeapify(size, i);
//			ArrayUtils.println(data);
		}
	}
	
	/**
	 * 堆排序
	 */
	public void sort() {
		sort(data);
	}

	/**
	 * 堆排序.
	 * n表示数据的个数，数组a中的数据从下标0到n-1的位置。
	 * 
	 * @param data
	 * @param size
	 */
	public void sort(Object[] data) {
		// 1.建堆
		buildHeap(data);
		// 2.排序
		int k = size;
		while (--k > 0) {
			swap(0, k); // 2.1 堆顶节点（第1个）与第k个节点互换，第k个节点已排好序。
			siftDownHeapify(k, 0); // 2.2 对堆顶节点进行堆化，向下堆化至k-1的位置后结束。
		}
	}

	/**
	 * 交换索引为i和j的元素位置
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j) {
		Object tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	/**
	 * 将索引index对应的节点向下堆化
	 * 
	 * @param heapifySize 从堆顶开始，到堆化结束的节点的元素个数
	 * @param index 进行堆化的节点索引
	 */
	protected abstract void siftDownHeapify(int heapifySize, int index);

	@SuppressWarnings("unchecked")
	protected int compare(Object o1, Object o2) {
		return ((Comparable<Object>) o1).compareTo((Comparable<Object>) o2);
	}
	
//	@SuppressWarnings("unchecked")
//	public E[] getData(E[] a) {
//		return (E[]) Arrays.copyOf(data, size, a.getClass());
//	}

	public E[] getData() {
		return (E[]) data;
	}

	public int getSize() {
		return size;
	}

}