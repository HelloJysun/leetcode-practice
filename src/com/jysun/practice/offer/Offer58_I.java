package com.jysun.practice.offer;

import java.util.Stack;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author json
 * @since 2021/8/22
 */
public class Offer58_I {

    public static void main(String[] args) {
        Offer58_I obj = new Offer58_I();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello world!  "));
        System.out.println(obj.reverseWords("a good   example"));
        System.out.println(obj.reverseWordsDoublePointer("the sky is blue"));
        System.out.println(obj.reverseWordsDoublePointer("  hello world!  "));
        System.out.println(obj.reverseWordsDoublePointer("a good   example"));
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] data = s.split(" ");
        for (String d : data) {
            if (d.length() != 0) {
                stack.push(d);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (!stack.isEmpty()) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public String reverseWordsDoublePointer(String s) {
        StringBuilder res = new StringBuilder();
        int lo = s.length() - 1, hi = lo;
        while (lo >= 0) {
            while (lo >= 0 && s.charAt(lo) == ' ') {
                lo--;
                hi--;
            }
            while (lo >= 0 && s.charAt(lo) != ' ') {
                lo--;
            }
            // 此时lo - hi为一个单词
            res.append(s, lo + 1, hi + 1).append(" ");
            hi = lo;
        }
        return res.toString().trim();
    }
}
