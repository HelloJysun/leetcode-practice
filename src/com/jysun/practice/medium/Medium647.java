package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * @date 2020/8/19 9:13
 */
public class Medium647 {

    public static void main(String[] args) {
        Medium647 obj = new Medium647();
        System.out.println(obj.countSubstrings("abc"));
        System.out.println(obj.countSubstrings("aaa"));
        System.out.println(obj.countSubstringsOpt(" "));
        System.out.println(obj.countSubstringsOpt("abc"));
        System.out.println(obj.countSubstringsOpt("aaa"));
    }

    /**
     * 暴力破解
     * 枚举所有可能出现的字符串情况并依次判断
     * 时间复杂度：O(N3)
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                res = isPalindromic(s.substring(i, j)) ? ++res : res;
            }
        }
        return res;
    }

    private boolean isPalindromic(String ss) {
        int start = 0;
        int end = ss.length() - 1;
        while (start < end) {
            if (ss.charAt(start) != ss.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 中心扩展法
     * 利用双指针从每个回文串边界向两边扩展，减少判断所有回文串遍历带来的时间消耗
     * 例如：abba
     * 此时走到了下标1处
     * 起始奇数串为 b,left = 1,right = left,b为回文串，接着指针向两边扩展abb不是回文串直接返回
     * 起始偶数串为 bb,left = 1,right = left + 1,bb为回文串，接着指针向两边扩展abba是回文串，再接着扩展时left和right超出边界范围直接返回
     *
     * @param s
     * @return
     */
    public int countSubstringsOpt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindromic(s, i, i);
            res += countPalindromic(s, i, i + 1);
        }
        return res;
    }

    private int countPalindromic(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }

}
