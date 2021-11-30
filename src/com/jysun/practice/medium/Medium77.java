package com.jysun.practice.medium;

import java.util.*;

/**
 * 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author jysun
 * @since 2021/11/22
 */
public class Medium77 {

    public static void main(String[] args) {
        Medium77 obj = new Medium77();
        System.out.println(obj.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        // 从1开始
        dfs(n, k, 1, stack, res);
        return res;
    }

    /**
     * ---递归---
     * 终止条件：list满了等于k直接返回
     * 返回值：无
     * 做什么：添加当前元素，然后后移一位
     */
    private void dfs(int n, int k, int begin, Stack<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 举例1 2 3 4取2个组合，即为1 2，然后弹出2后1 3。相当于从begin出发，不断右移组合
        for (int i = begin; i <= n; i++) {
            stack.push(i);
            dfs(n, k, i + 1, stack, res);
            stack.pop();
        }
    }
}
