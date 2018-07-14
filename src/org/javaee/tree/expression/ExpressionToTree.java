package org.javaee.tree.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.javaee.tree.BinaryNode;

/**
 * 构造并后序遍历表达式树
 */
public class ExpressionToTree {

	public static final Map<Character, Object> operatorMap = new HashMap<>();
	
	static {
		String operatorStr = "+-*/";
		for (int i = 0; i < operatorStr.length(); i++) {
			operatorMap.put(operatorStr.charAt(i), null);
		}
	}
	
	/**
	 * 构造表达式树
	 * 
	 * @param expression
	 * @return
	 */
	public static BinaryNode<Character> constructTree(String expression) {
		Stack<BinaryNode<Character>> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			// 如果是操作数，入栈
			if (!operatorMap.containsKey(ch)) {
				stack.push(new BinaryNode<Character>(ch));
			}
			// 如果是操作符，出栈两个数，形成树，再入栈
			else {
				BinaryNode<Character> rightChild = stack.pop();
				BinaryNode<Character> leftChild = stack.pop();
				BinaryNode<Character> node = new BinaryNode<Character>(ch, leftChild, rightChild);
				stack.push(node);
			}
		}
		// 最后一个操作数为根节点
		return stack.pop();
	}
	
	/**
	 * 后序遍历表达式树
	 * 
	 * @param node
	 */
	public static void postorderPrint(BinaryNode<Character> node) {
		if (node == null) {
			return;
		}
		if (node.leftChild != null) {
			postorderPrint(node.leftChild);
		}
		if (node.rightChild != null) {
			postorderPrint(node.rightChild);
		}
		System.out.print(node.element);
	}
	
	public static void main(String[] args) {
		String expression = "ab+cde+**";
		System.out.println("源表达式字符串：" + expression);
		BinaryNode<Character> root = constructTree(expression);
		System.out.print("后序遍历表达式树：");
		postorderPrint(root);
	}

}
