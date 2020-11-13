package org.javaee.lru;

public class LRUCacheTest {
	/**
     * 测试代码
     * @param args
     */
    public static void main(String [] args) {
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
