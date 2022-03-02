package com.jysun.practice.offer2.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author jysun
 * @since 2022/3/1
 */
public class FullArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new FullArray().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, 0, res);
        return res;
    }

    /**
     * 全排列：递归+回溯
     * 123的排列，从每个下标出发并添加标记，递归所有可能，比如1出发，递归进去访问123，因为1标记过了就可以通过visited标记剪枝
     *      1           2           3
     *   2     3     1     3     1     2   从左往右1 2 3都被剪枝了
     *   3     2     3     1     2     1   从左到右12 13 21 23 31 32都被剪枝了
     * 该解法只针对不包含重复元素
     */
    public void dfs(int[] nums, boolean[] visited, List<Integer> list, int length, List<List<Integer>> res) {
        if (length == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, list, length + 1, res);
            // 回溯重置标记并删除最后元素
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
