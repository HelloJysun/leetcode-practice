package com.jysun.practice.category.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author json
 * @since 2022/4/25
 */
public class LC3 {

    public static void main(String[] args) {
        System.out.println(new LC3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口维护最大无重复字符的最长子字符串
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            // 一旦有重复的就更新左窗口到重复字符的右边一位。是为了确保[left, right]内无重复字符串
            if (map.containsKey(ch)) {
//                abba 避免left移动到right左边情况出现，所以left要取之前字符右边和当前较大者
//                left = map.get(ch) + 1;
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right++);
            max = Math.max(max, right - left);
        }
        return max;
    }
}
