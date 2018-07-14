package org.javaee.tree;

public class BinaryNode<T> {

	public T element;
	public BinaryNode<T> leftChild;
	public BinaryNode<T> rightChild;

	public BinaryNode(T element) {
		this(element, null, null);
	}
	
	public BinaryNode(BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
		this(null, leftChild, rightChild);
	}

	public BinaryNode(T element, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
		this.element = element;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

}
