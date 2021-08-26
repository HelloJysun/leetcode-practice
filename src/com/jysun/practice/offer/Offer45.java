package com.jysun.practice.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 * 0 < nums.length <= 100
 *
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author jysun
 * @since 2021/8/25
 */
public class Offer45 {

    public static void main(String[] args) {
        Offer45 obj = new Offer45();
        int[] nums1 = {3, 30, 34, 5, 9, 0};
        int[] nums2 = {999999998, 999999997, 999999999};
        System.out.println(obj.minNumber(nums1));
        System.out.println(obj.minNumber(nums2));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(strs[i]);
        }
        return res.toString();
    }
}
