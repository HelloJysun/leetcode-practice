package com.jysun.practice.category.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 *
 * @author jysun
 * @since 2022/3/24
 */
public class LC47 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(new LC47().permuteUnique(nums));
    }

    /**
     * 全排列输入为不重复元素的数组，这里为输入可能有重复元素数组。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, track, visited);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(int[] nums, List<Integer> track, boolean[] visited) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 这里就不能和全排列一样根据元素是否存在来判定是否跳过选择。需要结合下标来确保每个元素塞进去
            // 一开始已经对元素排序，考虑112，一旦第一个1进入track，第二个1是可以进去的。但一旦第二个1进去后，第一个1再进去就会和前边重叠
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            visited[i] = true;
            backtrack(nums, track, visited);
            track.remove(track.size() - 1);
            visited[i] = false;
        }
    }
}
