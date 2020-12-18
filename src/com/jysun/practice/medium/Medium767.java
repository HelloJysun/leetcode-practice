package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * @date 2020/12/18 22:12
 */
public class Medium767 {

    public static void main(String[] args) {
        Medium767 obj = new Medium767();
        String Sa = "aaabbcc";
        System.out.println(obj.reorganizeString(Sa));

        String Sb = "aaab";
        System.out.println(obj.reorganizeString(Sb));

        String Sc = "";
        System.out.println(obj.reorganizeString(Sc));
    }

    public String reorganizeString(String S) {
        // 统计每个字符数
        int[] letters = new int[26];
        char[] original = S.toCharArray();
        for (char ch : original) {
            letters[ch - 'a']++;
        }
        // 找到最多字符数
        int threshold = (S.length() + 1) / 2;
        int maxIdx = 0;
        int max = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > max) {
                max = letters[i];
                maxIdx = i;
                if (max > threshold) {
                    return "";
                }
            }
        }
        // 将最多字符分割插入到data中
        char[] data = new char[S.length()];
        int cur = 0;
        while (letters[maxIdx]-- > 0) {
            data[cur] = (char) ('a' + maxIdx);
            cur += 2;
        }
        // 将剩余字符轮流插入data
        for (int i = 0; i < 26; i++) {
            while (letters[i]-- > 0) {
                if (cur >= S.length()) {
                    cur = 1;
                }
                data[cur] = (char) ('a' + i);
                cur += 2;
            }
        }

        return new String(data);
    }
}
