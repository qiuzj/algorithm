package org.javaee.tree.bst_adt;

/**
 * 基本徒手学习敲
 *
 */
public class BinarySearchTree2 {

	/**
	 * <pre>
	 * 查找.
	 * 
	 * 递推公式：
	 *   当前节点值是否相等？是则返回
	 *   比当前节点小，则递归查找左子树
	 *   否则，递归查找右子树
	 * 终止条件：当前节点为null
	 * </pre>
	 * 
	 * @param val
	 * @return
	 */
	public Node find(Node root, int val) {
		Node p = root;
		if (p == null) {
			return null;
		}
		if (p.value == val) {
			return p;
		}
		
		if (val < p.value) {
			return find(p.leftChild, val);
		}
		return find(p.rightChild, val);
	}
	
	/**
	 * <pre>
	 * 查找最小节点
	 * 
	 * 递推公式：从根节点开始，判断是否有左孩子节点，没有则返回。有则递归处理左孩子节点
	 * 终止条件：节点的leftChild为null
	 * </pre>
	 * 
	 * @param val
	 * @return
	 */
	public Node findMin(Node root) {
		if (root == null) {
			return null;
		}
		
		Node p = root;
		while (p.leftChild != null) {
			p = p.leftChild;
		}
		return p;
	}
	/**
	 * 递推公式：如果当前节点p的左孩子为null，则返回p；否则，递归查找左孩子节点
	 * 终止条件：当前节点为null，或者当前节点的左孩子为null
	 * 
	 * @param root
	 * @return
	 */
	public Node findMinR(Node root) {
		if (root == null) return null;
		if (root.leftChild == null) return root;
		return findMinR(root.leftChild);
	}
	
	/**
	 * <pre>
	 * 查找最大节点
	 * 
	 * 递推公式：从根节点开始，判断是否有右孩子节点，没有则返回。有则递归处理右孩子节点
	 * 终止条件：当前节点p为null，或当前节点p的rightChild为null
	 * </pre>
	 * 
	 * @param val
	 * @return
	 */
	public Node findMax(Node root) {
		if (root == null) {
			return null;
		}
		
		Node p = root;
		while (p.rightChild != null) {
			p = p.rightChild;
		}
		return p;
	}
	
	/**
	 * <pre>
	 * 查找前驱节点。如果有左孩子节点，则为左孩子节点。否则为右父亲。
	 * 
	 * 递推公式：
	 *   如果只有0或1个节点，则返回null
	 *   当前节点值是否相等？是则返回
	 *   比当前节点小，则递归查找左子树。左子节点存在则返回，否则返回null
	 *   否则，递归查找右子树。右孩子节点存在则返回，否则返回null
	 * 终止条件：当前节点为null
	 * </pre>
	 * 
	 * @param val
	 * @return
	 */
	public Node findPrevs(Node root, int val) {
		Node p = root;
		if (p == null || p.value == val) {
			return null;
		}
		
		return findPrevsHelper(p, val);
	}
	public Node findPrevsHelper(Node root, int val) {
		Node p = root;
		if (p == null) {
			return null;
		}
		if (p.value == val) {
			return p;
		}
		
		if (val < p.value) {
			Node pleft = findPrevs(p.leftChild, val);
			if (pleft != null) {
				return pleft.leftChild;
			}
			return null;
		}
		
		Node pright = findPrevs(p.rightChild, val);
		if (pright != null) {
			return p;
		}
		return null;
	}

	/**
	 * <pre>
	 * 插入.
	 * 先查找位置，类似于查找相同值，然后再插入空位置
	 * 
	 * 递推公式：
	 * 比节点小，查找左子树。遇到为空则作为左孩子插入
	 * 比节点大，查找右子树。遇到为空则作为右孩子插入
	 * 终止条件：当前待判断的节点为null，则插入到该null位置
	 * </pre>
	 * 
	 * @param val
	 * @return
	 */
	public Node insert(Node root, int val) {
		Node p = root;
		if (p == null) {
			return new Node(val);
		}
		
		if (val < p.value) {
			if (p.leftChild == null) {
				p.leftChild = new Node(val);
				return root;
			}
			return insert(p.leftChild, val);
		}
		
		if (p.rightChild == null) {
			p.rightChild = new Node(val);
			return root;
		}
		return insert(p.rightChild, val);
	}
	
	/**
	 * <pre>
1.叶子节点

直接删除即可

2.只有一个左节点或只有一个右节点

左节点或右节点直接代替被删除节点的位置

3.2个孩子节点
- 找到右子树最小值
- 替换被删除节点
- 对于最小值节点的右子树，转化为第2种删除的替换场景
	 * </pre>
	 * 
	 * @param root
	 * @param val
	 */
	public void delete(Node root, int val) {
		if (root == null) return;
		
	}
	
	class Node {
		int value;
		Node leftChild;
		Node rightChild;
		public Node(int value) {
			this.value = value;
		}
	}
	
}
