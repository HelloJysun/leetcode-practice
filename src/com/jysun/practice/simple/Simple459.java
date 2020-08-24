package com.jysun.practice.simple;

import java.util.Objects;

/**
 * @author Jysun
 * @description 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * @date 2020/8/24 9:59
 */
public class Simple459 {

    public static void main(String[] args) {
        Simple459 obj = new Simple459();
        System.out.println(obj.repeatedSubstringPattern("abab"));
        System.out.println(obj.repeatedSubstringPattern("aba"));
        System.out.println(obj.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(obj.repeatedSubstringPattern("aabaaba"));
        System.out.println(obj.repeatedSubstringPatternOpt("aabaaba"));
    }

    /**
     * 暴力破解
     * 依次从下标0处截取 1 字符串、2字符串... len/2 字符串然后遍历后续字串是否相等
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String pattern = s.substring(0, i);
            int offset = i;
            while (offset + i <= s.length() && Objects.equals(pattern, s.substring(offset, offset + i))) {
                offset += i;
                if (offset == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 如果 s 由 n 个子串 ss 构成，那么将第一个子串移到尾部依然是 s
     * 其中 1 < ss < n，那么把两个 s 串拼接在一起，移除第一个和最后一个字符时，s必定包含在其中
     * 这里只是假设 s 满足条件时，才符合上述性质
     * 从位置 1 开始查询，并希望查询结果不为位置 n，这与移除字符串的第一个和最后一个字符是等价的。
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatternOpt(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
