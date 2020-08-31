package com.jysun.practice.difficult;

import com.jysun.practice.practice.string.KMP;

import java.util.Objects;

/**
 * @author Jysun
 * @description 最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 * @date 2020/8/29 14:05
 */
public class Difficult214 {

    public static void main(String[] args) {
        Difficult214 obj = new Difficult214();
        System.out.println(obj.shortestPalindrome("aacecaaa"));
        System.out.println(obj.shortestPalindrome("abcd"));
        System.out.println(obj.shortestPalindrome("aba"));
        System.out.println(obj.shortestPalindrome("aaaaa"));
        System.out.println(obj.shortestPalindrome(""));
        System.out.println(obj.shortestPalindromeHash("aacecaaa"));
        System.out.println(obj.shortestPalindromeHash("abcd"));
        System.out.println(obj.shortestPalindromeHash("aba"));
        System.out.println(obj.shortestPalindromeHash("aaaaa"));
        System.out.println(obj.shortestPalindromeHash(""));
        System.out.println(obj.shortestPalindromeKmp("aacecaaa"));
        System.out.println(obj.shortestPalindromeKmp("abcd"));
        System.out.println(obj.shortestPalindromeKmp("aba"));
        System.out.println(obj.shortestPalindromeKmp("aaaaa"));
        System.out.println(obj.shortestPalindromeKmp(""));
    }

    /**
     * 将 s 字符串逆序添加到 s 前面
     * 逆序s 和 s的中间回文串留一个即可
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        StringBuilder reverse = new StringBuilder(s).reverse();
        int begin = 1;
        for (int i = 2; i <= reverse.length(); i++) {
            // 逆序后缀和正序前缀相等
            if (Objects.equals(reverse.substring(s.length() - i, s.length()), s.substring(0, i))) {
                begin = i;
            }
        }
        return reverse.append(s.substring(begin)).toString();
    }

    /**
     * base = ASCII_MAX
     * mul = mul * base % mod
     * hash(s[1,i]) = hash(s[1,i-1]) * base + s[i]
     * hash(s^[1,i]) = hash(s^[1,i-1]) + s[i] * mul
     *
     * robin karp算法（不是很理解）
     *
     * @param s
     * @return
     */
    public String shortestPalindromeHash(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int base = 127, mod = 100000007;
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < s.length(); i++) {
            left = (int) (((long) left * base + s.charAt(i)) % mod);
            right = (int) ((right + (long) mul * s.charAt(i)) % mod);
            if (left == right) {
                best = i;
            }
            mul = (int) ((long) mul * base % mod);
        }
        return new StringBuilder(s.substring(best + 1)).reverse().append(s).toString();
    }

    /**
     * 逆序后缀和正序前缀相等的视为回文串
     * 最后截取的就是最长的回文串，所以可以求 s 的next数组，然后从左到右找到最长的公共前缀然后截取拼接即可
     * 因为回文串的特性，将反转字符串加在原字符串后，前缀就回文串和后缀回文串相等，即求prefixTable[len - 1]最后一个值
     *
     * @param s
     * @return
     */
    public String shortestPalindromeKmp(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        // 加 # 是为了防止 aaa + aaa 这种情况得到6实际是3
        String str = s + "#" + new StringBuilder(s).reverse();

        int[] prefixTable = KMP.prefixTable(str);

        int maxLen = prefixTable[str.length() - 1];
        return new StringBuilder(s.substring(maxLen)).reverse().append(s).toString();
    }

}
