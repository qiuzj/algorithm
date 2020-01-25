package org.javaee.tree.bst_adt;

/**
 * 二叉树查找树。使用循环进行查找、插入、删除，逻辑更加简单高效。
 * <p>
 * 使用while，而不是递归，更加高效
 * 
 * @author 二进制之路
 *
 */
public class BinarySearchTreeUseWhile {
	private Node tree;

	/**
	 * 查找。
	 * <pre>
	 * 递推公式：
	 * 1.先取根节点，如果它等于我们要查找的数据，那就返回。
	 * 2.如果要查找的数据比根节点的值小，那就在左子树中递归查找；（左孩子节点作为下一轮查找的根节点）
	 * 3.如果要查找的数据比根节点的值大，那就在右子树中递归查找。（右孩子节点作为下一轮查找的根节点）
	 * 终止条件：
	 * 1.节点为null，即遍历完了，找不到，返回null
	 * 2.或者找到了，返回节点
	 * </pre>
	 * 
	 * @param data
	 * @return
	 */
	public Node find(int data) {
		Node p = tree;
		while (p != null) {
			if (data < p.data)
				p = p.left;
			else if (data > p.data)
				p = p.right;
			else
				return p;
		}
		return null;
	}

	/**
	 * 插入。
	 * <p>
	 * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置； 
	 * 如果不为空，就再递归遍历右子树，查找插入位置。
	 * <p>
	 * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
	 * 如果不为空，就再递归遍历左子树，查找插入位置。
	 * 
	 * @param data
	 */
	public void insert(int data) {
		// 如果是空树，则直接作为根节点
		if (tree == null) {
			tree = new Node(data);
			return;
		}

		Node p = tree;
		while (p != null) {
			// 插入右子树
			if (data > p.data) {
				if (p.right == null) { // 如果右子树为空，则作为右节点插入
					p.right = new Node(data);
					return;
				}
				p = p.right; // 继续在右子树中查找要插入的位置
			// 插入左子树
			} else { // data < p.data
				if (p.left == null) { // 如果左子树为空，则作为左节点插入
					p.left = new Node(data);
					return;
				}
				p = p.left; // 继续在左子树中查找要插入的位置
			}
		}
	}
	
	/**
	 * 删除。
	 * <p>
     * 三种情况：
     * <ul>
     * <li>叶子节点直接删除：直接将父节点指向要删除节点的指针置为 null。
     * <li>一个子节点：只有左子节点或者右子节点，将父节点指向要删除节点的的子节点。
     * <li>两个子节点：1.找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。2.再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。
     * </ul>
	 * 
	 * @param data
	 */
	public void delete(int data) {
		Node p = tree; // p 指向要删除的节点，初始化指向根节点
		Node pp = null; // pp 记录的是 p 的父节点
		
		// 查找节点
		while (p != null && p.data != data) {
			pp = p;
			if (data > p.data)
				p = p.right;
			else
				p = p.left;
		}
		if (p == null)
			return; // 没有找到

		// 要删除的节点有"两个"子节点
		if (p.left != null && p.right != null) { // 查找右子树中最小节点
			Node minP = p.right;
			Node minPP = p; // minPP 表示 minP 的父节点
			// 查找右子树中最小节点
			while (minP.left != null) {
				minPP = minP;
				minP = minP.left;
			}
			p.data = minP.data; // 将 minP 的数据替换到 p 中
			// 以上完成第1步：找到节点的右子树中的最小节点，把它替换到要删除的节点上。
			
			// 下面就变成了删除 minP 了
			p = minP;
			pp = minPP;
		}

		// 删除节点是叶子节点或者仅有一个子节点
		Node child; // p 的子节点
		if (p.left != null)
			child = p.left;
		else if (p.right != null) // 其实，else if和else可以合并为else child = p.right;
			child = p.right;
		else
			child = null;

		if (pp == null) // 删除的是根节点
			tree = child;
		else if (pp.left == p) // 将父节点指向要删除节点的的子节点。（左孩子）
			pp.left = child;
		else
			pp.right = child; // 将父节点指向要删除节点的的子节点。（右孩子）
	}

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}
}
