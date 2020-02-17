package org.javaee.tree.traversal.binarytree;

import org.javaee.tree.BinaryNode;

/**
 * <pre>
 * 二叉树的三种遍历方式。
 * 
 * 理解：每次递归进入函数，传入的节点理解为一棵新的子树，传进来的节点可以理解为新的根节点。
 * 先序遍历递推公式：1.先访问根节点 2.遍历左子树 3.遍历右子树。对于第二步、第三步的左右子树遍历，其实就是重复前面的三个步骤。
 * 
 * 
前序遍历的递推公式：
preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)

中序遍历的递推公式：
inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)

后序遍历的递推公式：
postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r

 * </pre>
 * @author 二进制之路
 * @param <T>
 *
 */
public class BinaryTreeTraversal<T> {

	/**
	 * 前序遍历（递归模板）
	 * 
	 * @param node
	 */
	public void preOrder(BinaryNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.element); // 访问节点，主逻辑处理
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	/**
	 * 中序遍历（递归模板）
	 * 
	 * @param node
	 */
	public void inOrder(BinaryNode<T> node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.print(node.element); // 访问节点，主逻辑处理
		inOrder(node.rightChild);
	}
	
	/**
	 * 后序遍历（递归模板）
	 * 
	 * @param node
	 */
	public void postOrder(BinaryNode<T> node) {
		if (node == null) {
			return;
		}
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.print(node.element); // 访问节点，主逻辑处理
	}
	
}
