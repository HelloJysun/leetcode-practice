package com.jysun.practice.offer2;

/**
 * 连续子数组的最大和
 *
 * @author json
 * @since 2022/3/2
 */
public class Practice42 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Practice42().maxSubArray(nums));
        System.out.println(new Practice42().maxSubArrayDp(nums));
    }

    public int maxSubArray(int[] nums) {
        // 如果nums子数组全为负数，0就是错误答案，所以一开始初始化可以为第一位数值
        int max = nums[0];
        int cnt = 0;
        for (int num : nums) {
            // 如果当前和已经<0直接重置cnt，从下一位重新算起
            if (cnt < 0) {
                cnt = num;
            } else {
                cnt += num;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    public int maxSubArrayDp(int[] nums) {
        int max = nums[0];
        int cnt = 0;
        for (int num : nums) {
            // 当前位置的最大和为当前数、累加和+当前数的较大者
            cnt = Math.max(num, cnt + num);
            max = Math.max(cnt, max);
        }
        return max;
    }
}
