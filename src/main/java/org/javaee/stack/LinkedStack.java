package org.javaee.stack;

import org.javaee.bean.SinglyListNode;

/**
 * 自定义链式栈
 *
 * @param <E>
 */
public class LinkedStack<E> {
	/** 栈顶 */
	private SinglyListNode<E> head;
	private int size;

	public LinkedStack() {
		this.head = null;
		this.size = 0;
	}

	public void push(E e) {
		SinglyListNode<E> newNode = new SinglyListNode<>(e, head);
		head = newNode;
		size++;
	}

	public E pop() {
		if (size == 0) {
			return null;
		}
		SinglyListNode<E> e = head;
		head = head.getNext();
		size--;
		return (E) e.getValue();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public SinglyListNode<E> getHead() {
		return head;
	}

}
