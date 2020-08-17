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
        new BFS().bfs(graph, 'E');
        new BFS().bfs(graph, 'F');
    }

    /**
     * graph key为结点，value为key的邻接点集合
     * 思路：从起始结点出发，找出所有未遍历过的邻接点并打印，再以邻接点作为出发点
     * 用队列存储遍历的邻接点
     * 遍历过的结点可以以一个set集合存储，遍历邻接点时判断是否已经访问过
     *
     * @param graph 字典结构
     * @param start 起始结点
     */
    private void bfs(Map<Character, List<Character>> graph, Character start) {
        Queue<Character> queue = new LinkedList<Character>() {{
            offer(start);
        }};
        Set<Character> visited = new HashSet<Character>() {{
            add(start);
        }};
        while (!queue.isEmpty()) {
            Character vertex = queue.poll();
            System.out.printf(vertex + " ");
            List<Character> nodes = graph.get(vertex);
            for (Character node : nodes) {
                if (!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                }
            }
        }
        System.out.println();
    }
}
