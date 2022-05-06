package com.jysun.practice.medium;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * LRU 缓存
 *
 * @author jysun
 * @since 2022/4/26
 */
public class Medium146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    static class LRUCache {

        private final HashMap<Integer, Integer> data;
        private final LinkedList<Integer> keys;
        private final int capacity;

        public LRUCache(int capacity) {
            this.data = new HashMap<>(capacity);
            this.keys = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }
            Integer value = data.get(key);
            // 移动key挪到尾部
            keys.remove(Integer.valueOf(key));
            keys.addLast(key);
            // 保存key-value
            data.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            // 容量不够时剔除头部key
            if (!data.containsKey(key) && data.size() == capacity) {
                Integer removeKey = keys.removeFirst();
                data.remove(removeKey);
            }
            keys.remove(Integer.valueOf(key));
            keys.addLast(key);
            data.put(key, value);
        }
    }
}