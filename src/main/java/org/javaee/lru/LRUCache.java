package org.javaee.lru;
/**
 * LRUCache接口类
 */
public interface LRUCache<E, T> {

    T get(E key);

    void put(E key, T value);
}
