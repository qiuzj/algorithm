package org.javaee.linkedlist;

/**
 * 使用双向链表实现LRU队列，暂不使用哈希提速
 *
 * @param <E>
 */
public class LRUDoubleLinkedList<E> {

	private int capacity;
	private CustomDoubleLinkedList<E> list;
	
	public LRUDoubleLinkedList(int capacity) {
		this.capacity = capacity;
		this.list = new CustomDoubleLinkedList<>();
	}
	
	public void visit(E e) {
		// 队列为空
		if (list.getSize() == 0) {
			list.addHead(e);
		// 队列不为空，访问的为头节点，则忽略
		} else if (list.isHead(e)) {
			// do nothing
		// 队列不为空，访问的为尾节点，则快速删除
		} else if (list.isTail(e)) {
			// 删除
			list.removeTail();
			// 插入头部
			list.addHead(e);
		// 非头尾节点，从头开始遍历
		} else {
			// 删除
			CustomDoubleLinkedList.Node<E> removedNode = list.remove(e);
			
			// 元素不存在队列中. 如果队列没满则后面插入即可，如果队列满了则要腾出一个位置
			if (removedNode == null) {
				// 队列已满，则删除尾节点
				if (list.getSize() >= capacity) {
					list.removeTail();
				}
			}
			
			// 无论节点原来是否存在，或队列是否满了，最后都要插入头部
			list.addHead(e);
		}
	}

	public CustomDoubleLinkedList<E> getList() {
		return list;
	}
	
}
