package com.jysun.practice.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author jysun
 * @since 2021/11/23
 */
public class Medium46 {

    public static void main(String[] args) {
        Medium46 obj = new Medium46();
        int[] nums = {1, 2, 3};
        System.out.println(obj.permute(nums));
    }

    /**
     * 排列和组合不同，排列讲究顺序，12和21不同
     * 如果数组有n个元素那就是分别从n个元素出发，然后取剩下元素
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> item = new Stack<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, item, visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Stack<Integer> item, boolean[] visited) {
        // 这里需要深拷贝
        if (nums.length == item.size()) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 当前元素访问过直接下一轮循环
            if (visited[i]) {
                continue;
            }
            // 未访问时直接放进结果集中，标记为访问，然后递归处理剩余元素
            item.push(nums[i]);
            visited[i] = true;
            dfs(nums, res, item, visited);
            // 递归返回时说明结果集已满，这时候弹出来栈顶元素处理剩下的元素
            item.pop();
            visited[i] = false;
        }
    }
}
