package com.jysun.practice.practice;

import com.jysun.practice.datastruct.Graph;

import java.util.*;

/**
 * @author Jysun
 * @description 深度优先搜索
 *
 * @date 2020/8/17 15:33
 */
public class DFS {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = Graph.getInstance();
        new DFS().dfs(graph, 'A');
        new DFS().dfs(graph, 'B');
        new DFS().dfs(graph, 'C');
        new DFS().dfs(graph, 'D');
        new DFS().dfs(graph, 'E');
        new DFS().dfs(graph, 'F');
    }

    private void dfs(Map<Character, List<Character>> graph, Character start) {
        Stack<Character> stack = new Stack<Character>() {{
            push(start);
        }};
        Set<Character> visited = new HashSet<Character>() {{
            add(start);
        }};
        while (!stack.isEmpty()) {
            Character vertex = stack.pop();
            System.out.printf(vertex + " ");
            List<Character> nodes = graph.get(vertex);
            for (Character node : nodes) {
                if (!visited.contains(node)) {
                    stack.push(node);
                    visited.add(node);
                }
            }
        }
        System.out.println();
    }
}
