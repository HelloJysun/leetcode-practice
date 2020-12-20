package com.jysun.practice.medium;

import java.util.Stack;

/**
 * @author Jysun
 * @description 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * @date 2020/12/20 21:34
 */
public class Medium316 {

    public static void main(String[] args) {
        Medium316 obj = new Medium316();
        String Sa = "bcabc";
        System.out.println(obj.removeDuplicateLetters(Sa));

        String Sb = "cbacdcbc";
        System.out.println(obj.removeDuplicateLetters(Sb));

        String Sc = "";
        System.out.println(obj.removeDuplicateLetters(Sc));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (stack.contains(ch)) {
                continue;
            }
            // 判断后续是否有与栈顶相同的元素，且后续有比栈顶小的
            while (!stack.isEmpty() && s.indexOf(stack.peek(), j) != -1 && ch < stack.peek()) {
                stack.pop();
            }
            stack.push(ch);
        }
        char[] data = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            data[i] = stack.get(i);
        }
        return new String(data);
    }
}
