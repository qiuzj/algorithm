package org.javaee.linkedlist;

/**
 * 自定义双向链表
 *
 * @param <E>
 */
public class CustomDoubleLinkedList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public CustomDoubleLinkedList() {
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void addHead(E e) {
		if (size == 0) {
			head = tail = new Node<E>(e, null, null);
		} else {
			head.prevs = new Node<E>(e, null, head);
			head = head.prevs;
		}
		size++;
	}
	
	public void addTail(E e) {
		if (size == 0) {
			head = tail = new Node<E>(e, null, null);
		} else {
			tail.next = new Node<E>(e, tail, null);
			tail = tail.next;
		}
		size++;
	}
	
	/**
	 * 将元素e插入到节点node之前
	 * 
	 * @param node
	 * @param e
	 */
	public void insert(Node<E> node, E e) {
		if (node.prevs == null) {
			addHead(e); // 优先实现单独的添加到头节点的方法
		} else {
			Node<E> newNode = new Node<>(e, node.prevs, node);
			node.prevs.next = newNode;
			node.prevs = newNode;
			size++;
		}
	}
	
	/**
	 * 组合的实现思想，先实现单独的删除头节点、删除尾节点、判断节点是否为指定值的方法，再实际删除，一步步来，简单且不易犯错
	 * @param e
	 * @return
	 */
	public Node<E> remove(E e) {
		checkBounds();
		Node<E> result = null;
		// 链表只有1个节点
		if (size == 1) {
			if (isEqual(head, e)) {
				result = removeHead();
			}
		// 链表有多个节点
		} else {
			// 头节点
			if (isEqual(head, e)) {
				result = removeHead();
			// 尾节点
			} else if (isEqual(tail, e)) {
				result = removeTail();
			} else {
				Node<E> p = head;
				while ((p = p.next) != tail) {
					if (isEqual(p, e)) {
						result = p;
						p.prevs.next = p.next;
						p.next.prevs = p.prevs;
						size--;
						break;
					}
				}
			}
		}
		return result;
	}
	
	public void remove(Node<E> node) {
		if (node.prevs == null) {
			removeHead();
		} else if (node.next == null) {
			removeTail();
		} else {
			node.prevs.next = node.next;
			node.next.prevs = node.prevs;
			size--;
		}
	}

	private boolean isEqual(Node<E> node, E e) {
		return node.getE() == e || node.getE().equals(e);
	}
	
	public boolean isHead(E e) {
		return size > 0 && isEqual(head, e);
	}
	
	public boolean isTail(E e) {
		return size > 0 && isEqual(tail, e);
	}

	public Node<E> removeHead() {
		checkBounds();
		Node<E> result = head;
		head = head.next;
		if (size >= 2) {
			result.next = null;
			head.prevs = null;
		}
		size--;
		return result;
	}
	
	public Node<E> removeTail() {
		checkBounds();
		Node<E> result = tail;
		tail = tail.prevs;
		if (size >= 2) {
			result.prevs = null;
			tail.next = null;
		}
		size--;
		return result;
	}

	private void checkBounds() {
		if (size <= 0) {
			throw new IllegalArgumentException("size is zero");
		}
	}
	
	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public static class Node<E> {
		private E e;
		private Node<E> prevs;
		private Node<E> next;
		public Node(E e, Node<E> prevs, Node<E> next) {
			this.e = e;
			this.prevs = prevs;
			this.next = next;
		}
		public E getE() {
			return e;
		}
		public void setE(E e) {
			this.e = e;
		}
		public Node<E> getPrevs() {
			return prevs;
		}
		public void setPrevs(Node<E> prevs) {
			this.prevs = prevs;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
}
