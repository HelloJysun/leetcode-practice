package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description Medium5 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @date 2020/5/21 7:53
 */
public class Medium5 {

    public static void main(String[] args) {
        Medium5 obj = new Medium5();
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("cbbd"));
        System.out.println(obj.longestPalindromeOpt("bb"));
        System.out.println(obj.longestPalindromeOpt("babad"));
        System.out.println(obj.longestPalindromeOpt("cbbd"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String res = String.valueOf(chars[0]);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(chars, i, j)) {
                    res = (j - i + 1) > res.length() ? s.substring(i, j + 1) : res;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(char[] chars, int l, int r) {
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * dp解法
     * 构造一个 s.length x s.length 二维数组描述字符串的所有组合可能
     *
     * @param s
     * @return
     */
    public String longestPalindromeOpt(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] data = s.toCharArray();
        int start = 0;
        int maxLength = 1;
        // 只需要判断一半，data[i] 到 data[j]，i为右边界，j为左边界
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 首尾不相等直接pass
                if (data[i] != data[j]) {
                    dp[i][j] = false;
                } else {
                    // 首尾相等，1/2/3个字母均符合
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if (dp[i][j] && i - j + 1 > maxLength) {
                    maxLength = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
