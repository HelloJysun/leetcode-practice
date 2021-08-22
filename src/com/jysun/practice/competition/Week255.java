package com.jysun.practice.competition;

import java.util.*;

/**
 * @author json
 * @since 2021/8/22
 */
public class Week255 {

    public static void main(String[] args) {
        Week255 obj = new Week255();
        int[] nums1 = {2, 5, 6, 9, 10};
        int[] nums2 = {7, 5, 6, 8, 3};
        int[] nums3 = {3, 3};
        System.out.println(obj.findGCD(nums1));
        System.out.println(obj.findGCD(nums2));
        System.out.println(obj.findGCD(nums3));

        String[] nums1_ = {"1"};
        String[] nums2_ = {"00", "01"};
        String[] nums3_ = {"1111","0011","0001"};
        System.out.println(obj.findDifferentBinaryString(nums1_));
        System.out.println(obj.findDifferentBinaryString(nums2_));
        System.out.println(obj.findDifferentBinaryString(nums3_));

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        while (max % min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return min;
    }

    public String findDifferentBinaryString(String[] nums) {
        String num = nums[0];
        int len = num.length();
        int max = 0;
        int index = 1;
        while (len-- > 0) {
            max += index;
            index *= 2;
        }
        Set<Integer> set = new HashSet<>();
        for (String s : nums) {
            set.add(binaryToNum(s));
        }
        for (int i = 0; i <= max; i++) {
            if (!set.contains(i)) {
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                while (s.length() != num.length()) {
                    s.insert(0, "0");
                }
                return s.toString();
            }
        }
        return "";
    }

    private int binaryToNum(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int bit = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                res += bit;
            }
            bit *= 2;
        }
        return res;
    }

}
