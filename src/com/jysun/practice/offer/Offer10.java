package com.jysun.practice.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 示例 2 :
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * @author jysun
 * @since 2021/8/9
 */
public class Offer10 {

    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        int[] nums = {5, 5, 4, 6, 10};
        System.out.println(offer10.subarraySum(nums, 10));
        System.out.println(offer10.subarraySumOpt(nums, 10));
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // i 为窗口大小
        for (int i = 1; i < nums.length; i++) {
            // 向右滑动
            for (int j = 0; j <= nums.length - i; j++) {
                int total = 0;
                int l = j;
                while (l < j + i) {
                    total += nums[l++];
                }
                if (total == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySumOpt(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int total = 0;
        int res = 0;
        for (int num : nums) {
            total += num;
            res += prefix.getOrDefault(total - k, 0);
            prefix.put(total, prefix.getOrDefault(total, 0) + 1);
        }
        return res;
    }
}
