package org.javaee.tree.traversal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.javaee.tree.BinaryNode;

/**
 * 二叉树遍历非递归版本.
 * 
 * @author Binary life
 *
 * @param <T>
 */
public class BinaryTreeTraversalWhile<T> {

	/**
	 * 广度优先遍历（迭代模板）. 从根到叶子节点，按层遍历.
	 * 时间复杂度：O(N)，其中N为结点的数量，每个节点访问1次.
	 * 空间复杂度：取决于保存栈节点个数. 最坏：O(logN)，平衡树. 最好：O(1)，链表.
	 * 
	 * @param root
	 */
	public void bfs(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        // 创建一个队列，用于存储待遍历的节点
        LinkedList<BinaryNode<T>> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
        	// 1.节点出列，访问节点，主逻辑处理
            BinaryNode<T> current = nodeQueue.poll();
            System.out.print(current.element);
            
            // 2.左孩子节点入列
            if (current.leftChild != null) {
                nodeQueue.add(current.leftChild);
            }
            
            // 3.右孩子节点入列
            if (current.rightChild != null) {
                nodeQueue.add(current.rightChild);
            }
        }
    }
	
	/**
	 * 前序遍历（迭代模板）.
	 * 时间复杂度：O(N)，其中N为结点的数量，每个节点访问1次.
	 * 空间复杂度：取决于保存栈节点个数. 最坏：O(logN)，平衡树. 最好：O(1)，链表.
	 * 
	 * @param root
	 */
	public void preOrder(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        // 创建一个栈，用于存储待遍历的节点
        LinkedList<BinaryNode<T>> nodeStack = new LinkedList<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            // 1.节点出栈，访问节点，主逻辑处理
            BinaryNode<T> current = nodeStack.pop();
            System.out.print(current.element);

            // 2.右孩子节点入栈
            if (current.rightChild != null) {
                nodeStack.push(current.rightChild);
            }
            
            // 3.左孩子节点入栈
            if (current.leftChild != null) {
                nodeStack.push(current.leftChild);
            }
        }
    }
	
	/**
	 * 中序遍历（迭代模板）.
	 * 时间复杂度：O(N)，其中N为结点的数量，每个节点访问1次.
	 * 空间复杂度：取决于保存栈节点个数. 最坏：O(N)，左斜树. 平均：O(logN)，平衡树. 最好：O(1)，右斜树.
	 * 
	 * @param root
	 */
	public void inOrder(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        // 创建一个栈，用于存储待遍历的节点
        LinkedList<BinaryNode<T>> nodeStack = new LinkedList<>();

        while (root != null || !nodeStack.isEmpty()) {
        	// 1.先将自己入栈，然后左孩子节点循环入栈. 后进先出，左孩子节点优先访问.
        	while (root != null) {
        		nodeStack.push(root);
        		root = root.leftChild;
        	}
        	
            // 2.节点出栈，访问节点，主逻辑处理
            BinaryNode<T> current = nodeStack.pop();
            System.out.print(current.element);
            
            // 3.右孩子节点作为下一个待遍历的子树根节点
            root = current.rightChild;
        }
    }
	
	/**
	 * 后序遍历（迭代模板）.
	 * 时间复杂度：O(N)，其中N为结点的数量，每个节点访问1次.
	 * 空间复杂度：O(N). 最坏：O(logN)，平衡树. 最好：O(1)，链表.
	 * 
	 * @param node
	 */
	public void postOrder(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        // 存放遍历的结果，按"前序遍历"的结果进行存储
        List<T> resultList = new ArrayList<>();
        
        // 创建一个栈，用于存储待遍历的节点
        LinkedList<BinaryNode<T>> nodeStack = new LinkedList<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            // 1.节点出栈，保存节点值
            BinaryNode<T> current = nodeStack.pop();
            resultList.add(current.element);

            // 2.左孩子节点入栈
            if (current.leftChild != null) {
                nodeStack.push(current.leftChild);
            }
            
            // 1.右孩子节点入栈
            if (current.rightChild != null) {
                nodeStack.push(current.rightChild);
            }
        }
        
        // 访问节点，主逻辑处理
        for (int i = resultList.size() - 1; i >= 0; i--) {
            System.out.print(resultList.get(i));
        }
    }
	
	/**
	 * 后序遍历（迭代模板2）.
	 * 这个版本不需要借助列表存储遍历结果，但逻辑非常复杂.
	 * 时间复杂度：O(N)，其中N为结点的数量，每个节点访问1次.
	 * 空间复杂度：O(N). 最坏：O(logN)，平衡树. 最好：O(1)，链表.
	 * 
	 * @param node
	 */
	public void postOrder2(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        // 创建一个栈，用于存储待遍历的节点
        LinkedList<BinaryNode<T>> nodeStack = new LinkedList<>();
        
        BinaryNode<T> lastVisit = null;

        while (root != null || !nodeStack.isEmpty()) {
        	// 1.先将自己入栈，然后左孩子节点循环入栈. 后进先出，左孩子节点优先访问.
        	while (root != null) {
        		nodeStack.push(root);
        		root = root.leftChild;
        	}
        	
            // 2.检查最左侧的节点，符合条件则访问节点
        	// 1）如果无右孩子节点，说明无子节点，则访问节点；
        	// 2）如果是上次访问节点的父节点，则访问节点。
            BinaryNode<T> current = nodeStack.peek();
            if (current.rightChild == null || current.rightChild == lastVisit) {
            	nodeStack.pop();
            	System.out.print(current.element); // 主逻辑处理
            	
            	// 保存最后一次访问的节点
            	lastVisit = current;
            	// 下一次直接处理栈顶节点
            	root = null;
        	// 3.右孩子节点作为下一个待遍历的子树根节点
            } else {
            	root = current.rightChild;
            }
        }
    }
	
}
