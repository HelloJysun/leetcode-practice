package com.jysun.practice.simple;

/**
 * @author Jysun
 * @description Simple680 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @date 2020/4/6 20:11
 */
public class Simple680 {

    public static void main(String[] args) {
        Simple680 obj = new Simple680();
//        System.out.println(obj.validPalindrome("aba"));
//        System.out.println(obj.validPalindrome("abca"));
        System.out.println(obj.validPalindrome("aaaaab"));
    }

    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int l = 0, r = arr.length - 1; l < r; l++ , r--) {
            if (arr[l] != arr[r]) {
                return isValid(arr, l + 1, r) || isValid(arr, l, r - 1);
            }
        }
        return true;
    }

    public boolean isValid(char[] arr, int l, int r) {
        while (l < r && arr[l] == arr[r]) {
            l++;
            r--;
        }
        return l >= r;
    }
}
