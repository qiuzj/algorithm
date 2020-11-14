package org.javaee.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 非常简陋的LRU实现. 只是说明原理，性能不好。
 *
 */
public class LRUCacheImpl implements LRUCache<Integer, Integer> {
	private List<Node> nodeList;
	private Map<Integer, Integer> keyIndexMap;
	private int capacity;

	public LRUCacheImpl(int capacity) {
		this.nodeList = new ArrayList<>(capacity);
		this.keyIndexMap = new HashMap<>();
		this.capacity = capacity;
	}

	public void put(Integer key, Integer value) {
		// key存在
		if (keyIndexMap.containsKey(key)) {
			int index = keyIndexMap.get(key); // 获得索引位置
			Node node = nodeList.get(index); // 获得节点对象
			node.value = value; // 更新值
			
			// 如果不在首位，则先删除，然后再添加到首位，最后更新一下Map索引
			if (index != 0) {
				nodeList.remove(index);
				// 添加到首位，优先级最高
				nodeList.add(0, node);
				// 刷新索引
				refreshMap();
			}
		// key不存在
		} else {
			// 空间已满，则先删除
			if (nodeList.size() == capacity) {
				int removeIndex = nodeList.size() - 1; // 队尾的索引号，待删除
				Node node = nodeList.get(removeIndex); // 队尾节点
				nodeList.remove(removeIndex); // 删除队尾节点
				keyIndexMap.remove(node.key); // 删除Map索引
			}
			// keyIndexMap.entrySet().forEach(e -> e.setValue(e.getValue() + 1));
			// 新节点添加到首位，优先级最高
			nodeList.add(0, new Node(key, value));
			// 缓存索引号
			keyIndexMap.put(key, 0);
			// 刷新索引
			refreshMap();
		}
	}

	public Integer get(Integer key) {
		// 存在key
		if (keyIndexMap.containsKey(key)) {
			int index = keyIndexMap.get(key); // 索引号
			Node node = nodeList.get(index); // 获得节点
			// 如果不是首节点，则先删除，再添加到队首，最后刷新Map索引号
			if (index != 0) {
				nodeList.remove(index);
				// 添加到首位，优先级最高
				nodeList.add(0, node);
				// 刷新索引
				refreshMap();
			}
			return node.value;
		} else {
			return null;
		}
	}

	/**
	 * 当nodeList发生变动时，刷新Map索引缓存
	 */
	private void refreshMap() {
		for (int i = 0; i < nodeList.size(); i++) {
			keyIndexMap.put(nodeList.get(i).key, i);
		}
	}

	class Node {
		public Integer key;
		public Integer value;

		public Node(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}
		// 不写getter、setter了
	}

	@Override
	public int size() {
		return nodeList.size();
	}

}