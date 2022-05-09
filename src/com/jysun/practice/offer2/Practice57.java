package com.jysun.practice.offer2;

import java.util.HashSet;
import java.util.Set;

/**
 * 和为s的两个数字
 *
 * @author jysun
 * @since 2022/5/9
 */
public class Practice57 {

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            };
        }
        return new int[0];
    }

    /**
     * 利用有序数组特性
     * 和大就收缩右指针，和小就收缩左指针
     */
    public int[] twoSumOpt(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int s = nums[left] + nums[right];
            if (s == target) {
                return new int[]{nums[left], nums[right]};
            } else if (s > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}
