package com.jysun.practice.offer;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 10000
 *
 * @author json
 * @since 2021/8/13
 */
public class Offer53 {

    public static void main(String[] args) {
        Offer53 obj = new Offer53();
        int[] nums1 = {0, 1, 3};
        int[] nums2 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] nums3 = {0};
        int[] nums4 = {0, 1};
        System.out.println(obj.missingNumber(nums1));
        System.out.println(obj.missingNumber(nums2));
        System.out.println(obj.missingNumber(nums3));
        System.out.println(obj.missingNumber(nums4));
    }

    public int missingNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            if (n++ != num) {
                return n - 1;
            }
        }
        return n;
    }
}
