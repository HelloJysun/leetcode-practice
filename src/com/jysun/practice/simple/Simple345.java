package com.jysun.practice.simple;

/**
 * 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 *
 * @author json
 * @since 2021/8/19
 */
public class Simple345 {

    public static void main(String[] args) {
        Simple345 obj = new Simple345();
        System.out.println(obj.reverseVowels(".,"));
    }

    public String reverseVowels(String s) {
        String yy = "aeiouAEIOU";
        char[] data = s.toCharArray();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            // 找到辅音字母，交换
            while (yy.indexOf(s.charAt(lo)) == -1 && lo < hi) {
                lo++;
            }
            while (yy.indexOf(s.charAt(hi)) == -1 && lo < hi) {
                hi--;
            }
            if (lo > hi) {
                break;
            }
            char tmp = data[lo];
            data[lo++] = data[hi];
            data[hi--] = tmp;
        }
        return new String(data);
    }
}
