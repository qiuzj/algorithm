package org.javaee.tree.traversal.binarytree;

import org.javaee.tree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树遍历
 * 
 * @author 二进制之路
 *
 */
public class BinaryTreeTraversalTester {

	private BinaryNode<String> root;
	private BinaryTreeTraversal binaryTreeTraversal;
	
	@Before
	public void init() {
		BinaryNode<String> g = new BinaryNode<>("G");
		BinaryNode<String> e = new BinaryNode<>("E", null, g);
		BinaryNode<String> d = new BinaryNode<>("D");
		BinaryNode<String> b = new BinaryNode<>("B", d, e);
		BinaryNode<String> f = new BinaryNode<>("F");
		BinaryNode<String> c = new BinaryNode<>("C", f, null);
		BinaryNode<String> a = new BinaryNode<>("A", b, c);
		root = a;
		
		binaryTreeTraversal = new BinaryTreeTraversal();
	}
	
	@Test
	public void testPreOrder() {
		binaryTreeTraversal.preOrder(root);
	}

	@Test
	public void testInOrder() {
		binaryTreeTraversal.inOrder(root);
	}
	
	@Test
	public void testPostOrder() {
		binaryTreeTraversal.postOrder(root);
	}
	
}
