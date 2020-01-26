package org.javaee.array;

/**
 * 下标为0的元素，为最久未访问的元素。
 *
 * @param <E>
 */
public class LRUArray<E> {

	private Object[] data;
	private int size;
	
	public LRUArray(int capacity) {
		data = new Object[capacity];
	}
	
	public void visit(E e) {
		if (size == 0) {
			data[size++] = e;
		} else if (data[size - 1] == e) {
			// do nothing
		} else { // 无论是否已缓存，都需要遍历一次来确认
			// 遍历找到后删除，插到尾部
			for (int i = 0; i < size - 1; i++) {
				// 已缓存. 大小不变
				if (data[i] == e) {
					for (int j = i + 1; j < size; j++) {
						data[j - 1] = data[j];
					}
					data[size - 1] = e;
					return;
				}
			}
			// 未缓存
			// 缓存未满，插到尾部
			if (size < data.length) {
				data[size++] = e;
			}
			// 缓存已满，删除下标为0的元素（即剩余的往前移1位），然后插入到尾部
			else {
				for (int i = 0; i < size - 1; i++) {
					data[i] = data[i + 1];
				}
				data[size - 1] = e;
			}
		}
	}

	public E[] getData() {
		return (E[]) data;
	}

	public int getSize() {
		return size;
	}
	
	
	
}
