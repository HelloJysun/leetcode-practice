package com.jysun.practice.simple;

import java.util.Objects;

/**
 * @author Jysun
 * @description Simple541 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * @date 2020/4/4 8:07
 */
public class Simple541 {

    public static void main(String[] args) {
        Simple541 obj = new Simple541();
        String s = "abcdefg";
        int k = 2;
        String res = obj.reverseStr(s, k);
        assert Objects.equals(res, "bacdfeg") : "error";
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int doubleKi = 0;
        while (doubleKi - 1 < chars.length) {
            if (chars.length - doubleKi < k) {
                reverse(chars, doubleKi, chars.length - 1);
            }
            if (chars.length - doubleKi < 2 * k && chars.length - doubleKi >= k) {
                reverse(chars, doubleKi, doubleKi + k - 1);
            }
            if (doubleKi != 0 && doubleKi - 1 < chars.length) {
                reverse(chars, doubleKi - 2 * k, doubleKi - k - 1);
            }
            doubleKi += 2 * k;
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }
    }
}
