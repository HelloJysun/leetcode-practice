package com.jysun.practice.category.greedy;

/**
 * 跳跃游戏
 *
 * @author json
 * @since 2022/5/19
 */
public class LC55 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new LC55().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 外部只返回了符合的随意不符合的这里判断，如果最远到达位置都到不了当前下标说明跨不过去了
            if (i > max) {
                return false;
            }
            // 不断更新当天最远可以到达的下标
            max = Math.max(i + nums[i], max);
        }
        // 退出条件为i>=nums.length说明可以到达
        return true;
    }
}
