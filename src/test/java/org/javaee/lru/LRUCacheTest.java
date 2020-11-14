package org.javaee.lru;

import org.junit.Test;

public class LRUCacheTest {

	/**
	 * 基于LinkedList实现，性能好
	 */
	@Test
	public void testWithLinkedList() {
		LRUCache<Integer, Integer> lruCache = new LRUCacheWithLinkedList<>(4);
		lruCache.put(1,1);
		System.out.println("lruCache.put(1,1)\nlruCache elements：" + lruCache);
		
		lruCache.put(2,2);
		System.out.println("\nlruCache.put(2,2)\nlruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.get(1)：" + lruCache.get(1));
		System.out.println("lruCache elements：" + lruCache);
		
		lruCache.put(3,3);
		System.out.println("\nlruCache.put(3,3)\nlruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.get(2)：" + lruCache.get(2));
		System.out.println("lruCache elements：" + lruCache);
		
		lruCache.put(4,4);
		System.out.println("\nlruCache.put(4,4)\nlruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.get(1)：" + lruCache.get(1));
		System.out.println("lruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.get(3)：" + lruCache.get(3));
		System.out.println("lruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.get(4)：" + lruCache.get(4));
		System.out.println("lruCache elements：" + lruCache);
		
		System.out.println("\nlruCache.size()：" + lruCache.size());
		System.out.println("lruCache elements：" + lruCache);
	}
    
	/**
     * 基于ArrayList实现，性能差
     */
	@Test
    public void testWithArrayList() {
        LRUCache<Integer, Integer> lruCache = new LRUCacheImpl(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}
