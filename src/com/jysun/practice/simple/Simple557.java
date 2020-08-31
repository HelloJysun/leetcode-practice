package com.jysun.practice.simple;

import java.util.Stack;

/**
 * @author Jysun
 * @description 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @date 2020/8/31 10:01
 */
public class Simple557 {

    public static void main(String[] args) {
        Simple557 obj = new Simple557();
        System.out.println(obj.reverseWords("Let's take LeetCode contest"));
        System.out.println(obj.reverseWordsOpt("Let's take LeetCode contest"));
    }

    /**
     * 迭代法
     * 既然是反转每个字符串，那么就用栈来回溯每个字符，一旦检测到空格存在就回溯栈打印即可
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.append(" ");
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    /**
     *
     *
     * @param s
     * @return
     */
    public String reverseWordsOpt(String s) {
        String[] ss = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String sss : ss) {
            res.append(new StringBuilder(sss).reverse()).append(" ");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
