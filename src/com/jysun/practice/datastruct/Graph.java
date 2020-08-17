package com.jysun.practice.datastruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jysun
 * @description 简单hash表实现图结构
 * @date 2020/8/17 15:36
 */
public class Graph {

    private volatile static Map<Character, List<Character>> INSTANCE;

    private Graph() {
    }

    public static Map<Character, List<Character>> getInstance() {
        if (INSTANCE == null) {
            synchronized (Graph.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HashMap<Character, List<Character>>() {{
                        put('A', Arrays.asList('B', 'C'));
                        put('B', Arrays.asList('A', 'C', 'D'));
                        put('C', Arrays.asList('A', 'B', 'D', 'E'));
                        put('D', Arrays.asList('B', 'C', 'E', 'F'));
                        put('E', Arrays.asList('C', 'D'));
                        put('F', Arrays.asList('D'));
                    }};
                }
            }
        }
        return INSTANCE;
    }

}
