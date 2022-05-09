package com.jysun.practice.category.binarysearch;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author jysun
 * @since 2022/5/8
 */
public class LC34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new LC34().searchRange(nums, 8)));
        System.out.println(new LC34().search(nums, 10));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1);
        if (left < nums.length && nums[left] == target) {
            res[0] = left;
            res[1] = right - 1;
        }
        return res;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 因为存在边界为mid，那么left==right时，存在原地打转情况
        while (left < right) {
            int mid = left + 1 + right >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 如果left=mid那就需要考虑4 5奇数9/2=4导致原地打转情况所以mid需要+1
                left = mid;
            }
        }
//        while (left < right) {
//            int mid = left + right >> 1;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
        return nums[left] == target ? left : -1;
    }
}
