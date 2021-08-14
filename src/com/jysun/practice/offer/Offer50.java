package com.jysun.practice.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 限制：
 * 0 <= s 的长度 <= 50000
 *
 * @author json
 * @since 2021/8/14
 */
public class Offer50 {

    public static void main(String[] args) {
        Offer50 obj = new Offer50();
        System.out.println(obj.firstUniqCharOpt("abaccdeff"));
        System.out.println(obj.firstUniqCharOpt("leetcode"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public char firstUniqCharOpt(String s) {
        int[] data = new int[26];
        for (char c : s.toCharArray()) {
            data[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (data[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
