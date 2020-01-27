package org.javaee.array;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by SpecialYang in 2018/12/7 2:00 PM.
 *
 * 基于数组实现的LRU缓存. 新元素放索引为0的位置，旧数据（最长时间未被访问）放到索引号最大的地方
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);
    // 容量
    private int capacity;
    // 队列数量
    private int count;
    // 存储缓存数据的数组
    private T[] value;
    // 缓存数据索引的Map集合：<元素值, 数组索引>
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 模拟访问某个值
     * 
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        // 从holder中查询是否已缓存，比遍历数组更加高效
        Integer index = holder.get(object);
        // 未缓存
        if (index == null) {
        	// 已满
            if (isFull()) {
                removeAndCache(object);
            // 未满
            } else {
                cache(object, count);
            }
        // 已缓存
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     * @param end
     */
    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移
     * 
     * @param object
     * @param end 数组右移的边界
     */
    public void cache(T object, int end) {
        rightShift(end); // 原有数据右移一位
        value[0] = object; // 新元素放到头部，相当于放到队列首部
        holder.put(object, 0); // 缓存索引号
        count++; // 缓存数量加1
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部.
     * 记得要删除holder缓存
     * 
     * @param object
     */
    public void removeAndCache(T object) {
        T key = value[--count]; // 获取最后一个元素，数量减1
        holder.remove(key); // 删除最后一个元素，淘汰队尾最长时间没有访问的元素
        // 缓存新的元素
        cache(object, count);
    }

    /**
     * end左边的数据（0~end-1）统一右移一位
     * 
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i]; // 右移一位
            holder.put(value[i], i + 1); // 更新元素的缓存索引
        }
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
