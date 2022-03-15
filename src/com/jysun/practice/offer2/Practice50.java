package com.jysun.practice.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author json
 * @since 2022/3/15
 */
public class Practice50 {
    public static void main(String[] args) {
        System.out.println(new Practice50().solution("abaccdeff"));
    }

    public char solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }
}
