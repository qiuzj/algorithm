package org.javaee.stack;

/**
 * 自定义顺序栈
 *
 * @param <E>
 */
public class ArrayStack<E> {
	/** 索引为0的元素为栈顶，最大索引对应的元素为栈顶 */
	private Object[] data;
	private int size;
	
	public ArrayStack(int capacity) {
		this.data = new Object[capacity];
		this.size = 0;
	}
	
	public void push(E e) {
		// 如果数组满了，则2倍扩容
		if (size == data.length) {
			resize();
		}
		// 入栈
		data[size++] = e;
	}
	
	private void resize() {
		int newCapacity = 2 * size;
		if (newCapacity < 0) {
			newCapacity = size + 1;
		}
		Object[] newData = new Object[newCapacity];
		System.arraycopy(data, 0, newData, 0, size);
		data = newData;
	}
	
	@SuppressWarnings("unchecked")
	public E pop() {
		if (size == 0) {
			return null;
		}
		size--;
		E e = (E) data[size];
		data[size] = null;
		return e;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public Object[] getData() {
		return data;
	}
	
}
