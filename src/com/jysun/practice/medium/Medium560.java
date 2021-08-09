package com.jysun.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jysun
 * @description Medium560 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * @date 2020/5/15 7:29
 */
public class Medium560 {

    public static void main(String[] args) {
        Medium560 obj = new Medium560();
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {0};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {4, 6, 5, 5, 10};
        System.out.println(obj.subarraySum(nums1, 2));
        System.out.println(obj.subarraySum(nums2, 1));
        System.out.println(obj.subarraySum(nums3, 3));
        System.out.println(obj.subarraySum(nums4, 10));
    }

    /**
     * 最主要的一点在于连续子数组
     * 滑动窗口[i, j]的和 sum[i, j]
     * = (nums[0] + ... + nums[i - 1] + nums[i] + ... + nums[j]) - (nums[0] + ... + nums[i - 1])
     * = sum[j] - sum[i - 1]
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // 前缀和 - 出现次数
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int total = 0;
        int res = 0;
        for (int num : nums) {
            total += num;
            // 有（前缀和 - k） 的 key 说明存在连续子数组。这个子数组就是该 key 位置到当前前缀和位置
            if (prefix.containsKey(total - k)) {
                res += prefix.get(total - k);
            }
            prefix.put(total, prefix.getOrDefault(total, 0) + 1);
        }
        return res;
    }
}
