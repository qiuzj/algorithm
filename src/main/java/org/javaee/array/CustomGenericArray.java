package org.javaee.array;

/**
 * 徒手动态数组.
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * 
 * @author qiuzj
 *
 */
public class CustomGenericArray<T> {

	private Object[] data;
	private int size;
	
	public CustomGenericArray(int capacity) {
		data = new Object[capacity];
	}
	
	public T get(int i) {
		checkBounds(i);
		return (T) data[i];
	}

	private void checkBounds(int i) {
		if (i < 0 || i >= size) {
			throw new IllegalArgumentException("index out of bound");
		}
	}
	
	public void add(T v) {
		resize();
		data[size++] = v;
	}
	
	public T set(int i, T v) {
		checkBounds(i);
		T old = (T) data[i];
		data[i] = v;
		return old;
	}

	private void resize() {
		if (size >= data.length) {
			// 扩容
			int newLength = data.length * 2;
			if (newLength < 0) {
				newLength = Integer.MAX_VALUE;
			}
			Object[] newA = new Object[newLength];
			System.arraycopy(data, 0, newA, 0, data.length);
			data = newA;
		}
	}
	
	public void insert(int i, T v) {
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
	
	public void remove(int i) {
		checkBounds(i);
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
	
	public void addFirst(T v) {
		insert(0, v);
	}
	
	public void addLast(T v) {
		add(v);
	}
	
	public T removeFirst() {
		checkBounds(0);
		T old = (T) data[0];
		remove(0);
		return old;
	}
	
	public T removeLast() {
		checkBounds(size - 1);
		T old = (T) data[size - 1];
		remove(size - 1);
		return old;
	}

	public T[] getData() {
		Object[] newA = new Object[size];
		System.arraycopy(data, 0, newA, 0, size);
		return (T[]) newA;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(T v) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(v)) {
				return true;
			}
		}
		return false;
	}
	
	public int find(T v) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(v)) {
				return i;
			}
		}
		return -1;
	}

	public void setData(T[] data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
