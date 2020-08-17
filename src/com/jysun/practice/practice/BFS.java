package com.jysun.practice.practice;

import com.jysun.practice.datastruct.Graph;

import java.util.*;

/**
 * @author Jysun
 * @description 广度优先搜索
 *
 * @date 2020/8/17 15:13
 */
public class BFS {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = Graph.getInstance();
        new BFS().bfs(graph, 'A');
        new BFS().bfs(graph, 'B');
        new BFS().bfs(graph, 'C');
        new BFS().bfs(graph, 'D');
        Map<Character, Character> parent = new BFS().bfs(graph, 'E');
        new BFS().bfs(graph, 'F');
        System.out.println(parent);
        // 找到 A -> E 的最短路径
        Character node = 'A';
        int len = 0;
        while (node != null) {
            len++;
            System.out.printf(node + "");
            node = parent.get(node);
            if (node != null) {
                System.out.printf(" -> ");
            }
        }
        System.out.println("A -> E 最短路径：" + len);
    }

    /**
     * graph key为结点，value为key的邻接点集合
     * 思路：从起始结点出发，找出所有未遍历过的邻接点并打印，再以邻接点作为出发点
     * 用队列存储遍历的邻接点
     * 遍历过的结点可以以一个set集合存储，遍历邻接点时判断是否已经访问过
     *
     * @param graph 字典结构
     * @param start 起始结点
     * @return parent 邻接点的父节点，可通过该hash表找到两个结点的最短连接路径
     */
    private Map<Character, Character> bfs(Map<Character, List<Character>> graph, Character start) {
        Queue<Character> queue = new LinkedList<Character>() {{
            offer(start);
        }};
        Set<Character> visited = new HashSet<Character>() {{
            add(start);
        }};
        Map<Character, Character> parent = new HashMap<Character, Character>() {{
            put(start, null);
        }};
        while (!queue.isEmpty()) {
            Character vertex = queue.poll();
            System.out.printf(vertex + " ");
            List<Character> nodes = graph.get(vertex);
            for (Character node : nodes) {
                if (!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                    parent.put(node, vertex);
                }
            }
        }
        System.out.println();
        return parent;
    }
}
