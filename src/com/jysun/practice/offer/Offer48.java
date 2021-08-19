package com.jysun.practice.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * s.length <= 40000
 *
 * @author json
 * @since 2021/8/19
 */
public class Offer48 {

    public static void main(String[] args) {
        Offer48 obj = new Offer48();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        // fekajn
        System.out.println(obj.lengthOfLongestSubstring("jeaskjjfekajnfkj"));
    }

    /**
     * dp[i] 表示 [0, i] 下标的字符串中最长子串长度
     * 当前i下标字符串如果不在[0, i-1]中则dp[i] = dp[i - 1] + 1
     * 包含了则等于dp[i - 1]
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        // l - r为滑动窗口范围
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // 碰到重复就干掉最左侧干掉，相当于用set实现双端队列效果，确保不会有重复元素
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            // 比较窗口大小是否比历史最大值大
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
