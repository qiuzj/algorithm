package org.javaee.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 基于LinkedList实现链表，性能更好. 【推荐】<br>
 * 唯一缺点是，删除LinkedList中的某个节点比较耗时，需要进行遍历.
 */
public class LRUCacheWithLinkedList<E, T> implements LRUCache<E, T> {

	/** 实现LRU算法的链表. 最近最少使用的放到链尾，最近访问的放到链头. */
	private LinkedList<E> lruList;
	/** 用于快速根据key找到节点 */
	private Map<E, Node> keyMap;
	/** 最大容量 */
	private int capacity;
	
	public LRUCacheWithLinkedList(int capacity) {
		this.capacity = capacity;
		this.lruList = new LinkedList<>();
		this.keyMap = new HashMap<>();
	}
	
	@Override
	public T get(E key) {
		// 已存在
		if (keyMap.containsKey(key)) {
			// 当前访问的节点移到链首
			Node currentNode = moveToFirst(key);
			// 返回
			return currentNode.value;
		}

		// 不存在
		return null;
	}

	@Override
	public void put(E key, T value) {
		// 已存在
		if (keyMap.containsKey(key)) {
			// 当前访问的节点移到链头
			Node currentNode = moveToFirst(key);
			currentNode.value = value;
		// 不存在，添加新节点到链头
		} else {
			// 如果存储空间已满 ，则先删除链尾节点. 重点：Map也要删除
			if (lruList.size() == capacity) {
				E lastKey = lruList.removeLast();
				keyMap.remove(lastKey);
			}
			
			// 添加新节点到链头
			Node newNode = new Node(key, value);
			lruList.addFirst(key);
			keyMap.put(key, newNode);
		}
	}
	
	/**
	 * 将指定节点移至链头
	 * 
	 * @param key
	 * @return
	 */
	private Node moveToFirst(E key) {
		// 当前节点
		Node currentNode = keyMap.get(key);
		// 链头节点
		E firstKey = lruList.peek();
		// 如果当前节点不在链头，则移到链头
		if (firstKey != key && !firstKey.equals(key)) {
			lruList.remove(key); // 删除效率比较低，LinkedList没有提供获取内部节点的方法，因此无法直接摘除节点而需要采用遍历的方式.
			lruList.addFirst(key);
		}
		return currentNode;
	}
	
	@Override
	public String toString() {
		return lruList.stream()
				.map(E::toString)
				.collect(Collectors.joining(","));
	}

	@Override
	public int size() {
		return lruList.size();
	}
	
	class Node {
		E key;
		T value;
		public Node(E key, T value) {
			this.key = key;
			this.value = value;
		}
	}

}
