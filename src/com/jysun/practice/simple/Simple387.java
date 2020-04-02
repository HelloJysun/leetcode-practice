package com.jysun.practice.simple;

/**
 * @author Jysun
 * @description Simple387 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *注意事项：您可以假定该字符串只包含小写字母。
 *
 * @date 2020/4/2 12:58
 */
public class Simple387 {

    public static void main(String[] args) {
        Simple387 obj = new Simple387();
        System.out.println(obj.firstUniqChar("leetcode"));
        System.out.println(obj.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[123];
        for (char c : chars) {
            map[c] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
