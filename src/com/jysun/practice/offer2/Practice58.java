package com.jysun.practice.offer2;

import java.util.Objects;

/**
 * 翻转单词顺序
 *
 * @author json
 * @since 2022/5/11
 */
public class Practice58 {

    public static void main(String[] args) {
        System.out.println(new Practice58().reverseWords("I am   a student.  "));
        System.out.println(new Practice58().reverseWordsOpt("I am   a student.  "));
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (Objects.equals(words[i], "")) {
                continue;
            }
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    /**
     * 逆序遍历双指针维护一个窗口，一旦左边界碰到空格就将[left+1, right]的单词放进去
     */
    public String reverseWordsOpt(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim();
        int left = s.length() - 1, right = s.length() - 1;
        while (left >= 0) {
            // 去除括号
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
                right--;
            }
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            res.append(s, left + 1, right + 1).append(" ");
            right = left;
        }
        return res.toString();
    }
}
