package com.jysun.practice.category.greedy;

/**
 * 跳跃游戏 II
 *
 * @author json
 * @since 2022/5/19
 */
public class LC45 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 2, 3};
        System.out.println(new LC45().jump(nums));
    }

    /**
     * 题目所给假设总是可以到达数组最后一个位置
     * 所以可以维护一个最远可以到达的下标并且走到最远下标步骤就累加
     * 但最远可以到达下标是随着下标步数不断更新的，所以要保留上一个位置的最远下标，一旦到达就更新
     */
    public int jump(int[] nums) {
        int max = 0, step = 0, preMax = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == preMax) {
                preMax = max;
                step++;
            }
        }
        return step;
    }
}
