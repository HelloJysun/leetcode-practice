package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description Medium152  乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @date 2020/5/18 7:48
 */
public class Medium152 {

    public static void main(String[] args) {
        Medium152 obj = new Medium152();
        int[] nums = {2,3,-2,4};
        System.out.println(obj.maxProduct(nums));
        System.out.println(obj.maxProductOpt(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            for (int j = i; j < nums.length; j++) {
                cnt = cnt * nums[j];
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

    /**
     * dp解法，由于存在正负数情况，需要保存最大积和最小积两种状态数组
     * 正数采用最大积数组，负数采用最小积数组
     *
     * @param nums
     * @return
     */
    public int maxProductOpt(int[] nums) {
        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        max[0] = 1;
        min[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 0) {
                int tmp = max[i - 1];
                max[i - 1] = min[i - 1];
                min[i - 1] = tmp;
            }
            max[i] = Math.max(max[i - 1] * nums[i - 1], nums[i - 1]);
            min[i] = Math.min(min[i - 1] * nums[i - 1], nums[i - 1]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
