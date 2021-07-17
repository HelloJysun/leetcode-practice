package com.jysun.practice.medium;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author json
 * @since 2021/7/17
 */
public class Medium53 {

    public static void main(String[] args) {
        Medium53 obj = new Medium53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
        System.out.println(obj.maxSubArrayDP(nums));
    }

    /**
     * 从当前数字开始累加和，如果累加和为负数完全没必要再累加下去，数越来越小，此时重置为当前数
     * 如果累加和是正数，可以累加后边的数，然后判断累加和是否是更大的数
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 兼容只有一个数的情况
        int max = Integer.MIN_VALUE;
        int prefix = 0;
        for (int num : nums) {
            if (prefix < 0) {
                prefix = num;
            } else {
                prefix += num;
            }
            max = Math.max(prefix, max);
        }
        return max;
    }

    /**
     * f(i) = nums[i] 或 f(i) = f(i - 1) + nums[i]（同理，加或者不加的问题）
     * f(i - 1) > 0 累加，f(i - 1) <= 0 不累加重置为当前数
     *
     * @param nums
     * @return
     */
    public int maxSubArrayDP(int[] nums) {
        int max = nums[0];
        int prefix = 0;
        for (int num : nums) {
            // num 还是 f(i - 1) + num
            prefix = Math.max(num, prefix + num);
            max = Math.max(max, prefix);
        }
        return max;
    }
}
