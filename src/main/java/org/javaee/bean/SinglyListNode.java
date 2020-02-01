package org.javaee.bean;

/**
 * 单向链表节点 
 *
 * @param <E>
 */
public class SinglyListNode<E> {

	private Object value;
	private SinglyListNode<E> next;

	public SinglyListNode(Object value) {
		this.value = value;
	}
	
	public SinglyListNode(Object value, SinglyListNode<E> next) {
		this.value = value;
		this.next = next;
	}
	
	public E getValue() {
		return (E) value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public SinglyListNode<E> getNext() {
		return next;
	}

	public void setNext(SinglyListNode<E> next) {
		this.next = next;
	}

}
