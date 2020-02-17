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
	private BinaryTreeTraversal<String> binaryTreeTraversal;
	private BinaryTreeTraversalWhile<String> binaryTreeTraversalWhile;
	
	@Before
	public void init() {
		BinaryNode<String> k = new BinaryNode<>("K");
		BinaryNode<String> j = new BinaryNode<>("J", k, null);
		BinaryNode<String> i = new BinaryNode<>("I", null, j);
		BinaryNode<String> h = new BinaryNode<>("H");
		BinaryNode<String> g = new BinaryNode<>("G");
		BinaryNode<String> e = new BinaryNode<>("E", null, g);
		BinaryNode<String> d = new BinaryNode<>("D");
		BinaryNode<String> b = new BinaryNode<>("B", d, e);
		BinaryNode<String> f = new BinaryNode<>("F", h, i);
		BinaryNode<String> c = new BinaryNode<>("C", f, null);
		BinaryNode<String> a = new BinaryNode<>("A", b, c);
		root = a;
		
		binaryTreeTraversal = new BinaryTreeTraversal<>();
		binaryTreeTraversalWhile = new BinaryTreeTraversalWhile<>();
	}
	
	@Test
	public void testPreOrder() {
		System.out.println("递归：");
		binaryTreeTraversal.preOrder(root);
		
		System.out.println("\n迭代：");
		binaryTreeTraversalWhile.preOrder(root);
	}

	@Test
	public void testInOrder() {
		System.out.println("递归：");
		binaryTreeTraversal.inOrder(root);

		System.out.println("\n迭代：");
		binaryTreeTraversalWhile.inOrder(root);
	}
	
	@Test
	public void testPostOrder() {
		System.out.println("递归：");
		binaryTreeTraversal.postOrder(root);

		System.out.println("\n迭代：");
		binaryTreeTraversalWhile.postOrder(root);
	}

	@Test
	public void testBfs() {
		binaryTreeTraversalWhile.bfs(root);
	}
	
}
