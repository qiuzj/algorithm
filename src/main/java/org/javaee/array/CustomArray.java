package org.javaee.array;

/**
 * 徒手动态数组.
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * 
 * @author qiuzj
 *
 */
public class CustomArray {

	private int[] data;
	private int size;
	
	public CustomArray(int capacity) {
		data = new int[capacity];
	}
	
	public int get(int i) {
		if (i < 0 || i >= size) {
			throw new IllegalArgumentException("index out of bound");
		}
		return data[i];
	}
	
	public void add(int v) {
		resize();
		data[size++] = v;
	}

	private void resize() {
		if (size >= data.length) {
			// 扩容
			int newLength = data.length * 2;
			if (newLength < 0) {
				newLength = Integer.MAX_VALUE;
			}
			int[] newA = new int[newLength];
			System.arraycopy(data, 0, newA, 0, data.length);
			data = newA;
		}
	}
	
	public void insert(int v, int i) {
		if (i < 0 || i > size) {
			throw new IllegalArgumentException("index out of bound");
		}
		resize();
		// 添加到末尾
		if (i == size) {
			add(v);
		} else {
			// i及之后的元素后移一位
			for (int j = size - 1; j >= i; j--) {
				data[j + 1] = data[j];
			}
			data[i] = v;
			size++;
		}
	}
	
	public void delete(int i) {
		if (i < 0 || i >= size) {
			throw new IllegalArgumentException("index out of bound");
		}
		// 删除末尾元素
		if (i == size - 1) {
			size--;
		} else {
			for (int j = i + 1; j < size; j++) {
				data[j - 1] = data[j];
			}
			size--;
		}
	}

	public int[] getData() {
		int[] newA = new int[size];
		System.arraycopy(data, 0, newA, 0, size);
		return newA;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
