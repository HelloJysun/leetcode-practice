package com.jysun.practice.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author jysun
 * @since 2022/4/26
 */
public class Medium146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    static class LRUCacheS extends LinkedHashMap<Integer, Integer> {
        int capacity;
        public LRUCacheS(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * 重写移除最久未使用的节点，即Linked头节点，该方法在插入节点后回调
         * {@link HashMap#afterNodeInsertion(boolean)}
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
        
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
            moveTail(key);
            return data.get(key);
        }

        public void put(int key, int value) {
            // 容量不够时剔除头部key
            if (!data.containsKey(key) && data.size() == capacity) {
                Integer removeKey = keys.removeFirst();
                data.remove(removeKey);
            }
            data.put(key, value);
            moveTail(key);
        }

        public void moveTail(int key) {
            keys.remove(Integer.valueOf(key));
            keys.addLast(key);
        }
    }
}