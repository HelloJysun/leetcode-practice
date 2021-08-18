package com.jysun.practice.offer;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author json
 * @since 2021/8/18
 */
public class Offer42 {

    public static void main(String[] args) {
        Offer42 obj = new Offer42();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
        System.out.println(obj.maxSubArrayDp(nums));
        System.out.println(obj.maxSubArrayDpOpt(nums));
    }

    public int maxSubArray(int[] nums) {
        int prefix = 0, max = 0;
        for (int num : nums) {
            // 前缀和小于0时，直接从当前元素开始算
            if (prefix < 0) {
                prefix = num;
            } else {
                prefix = prefix + num;
            }
            max = Math.max(max, prefix);
        }
        return max;
    }

    /**
     * dp[i] 代表以 nums[i] 结尾的连续子数组的和
     */
    public int maxSubArrayDp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            // 如果dp[i - 1] > 0，取 dp[i - 1] + nums[i]
            // 如果dp[i - 1] <= 0，取 nums[i] 即可
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArrayDpOpt(int[] nums) {
        int res = nums[0], prefix = 0;
        for (int num : nums) {
            prefix = Math.max(prefix + num, num);
            res = Math.max(res, prefix);
        }
        return res;
    }
}
