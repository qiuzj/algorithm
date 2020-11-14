package org.javaee.lru;

/**
 * LRU接口
 */
public interface LRUCache<E, T> {

	/**
	 * 根据键获取值
	 * 
	 * @param key
	 * @return
	 */
    T get(E key);

    /**
     * 存储键值对
     * 
     * @param key
     * @param value
     */
    void put(E key, T value);
    
    /**
     * 已存储的元素数量
     * 
     * @return
     */
    int size();
}
