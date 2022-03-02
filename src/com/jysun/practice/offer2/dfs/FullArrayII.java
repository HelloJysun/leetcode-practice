package com.jysun.practice.offer2.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 *
 * @author jysun
 * @since 2022/3/1
 */
public class FullArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new FullArrayII().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, 0, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> list, int length, List<List<Integer>> res) {
        if (length == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 因为包含重复元素，所以我们要寻找一种方法来对已经添加过的排列组合进行剪枝
            // nums数组已经是有序的，即使有重复元素，通过访问标记判断剪枝或者确保
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list, length + 1, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
