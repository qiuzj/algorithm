package org.javaee.tree.traversal.binarytree;

import org.javaee.tree.BinaryNode;

/**
 * 二叉树的三种遍历方式
 * 
 * @author 二进制之路
 *
 */
public class BinaryTreeTraversal {

	public void preOrder(BinaryNode<?> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.element);
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	public void inOrder(BinaryNode<?> node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.print(node.element);
		inOrder(node.rightChild);
	}
	
	public void postOrder(BinaryNode<?> node) {
		if (node == null) {
			return;
		}
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.print(node.element);
	}
	
}
