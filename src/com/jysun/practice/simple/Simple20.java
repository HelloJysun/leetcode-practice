package com.jysun.practice.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Jysun
 * @description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * @date 2020/8/14 15:23
 */
public class Simple20 {

    public static void main(String[] args) {
        Simple20 obj = new Simple20();
        System.out.println(obj.isValid(""));
        System.out.println(obj.isValid("["));
        System.out.println(obj.isValid("]"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("([)]"));
        System.out.println(obj.isValid("{[]}"));

        System.out.println(obj.isValidOpt("()[]{}"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (!stack.isEmpty() && ((ch == ')' && stack.peek() == '(')
                    || (ch == ']' && stack.peek() == '[')
                    || (ch == '}' && stack.peek() == '{'))) {
                stack.pop();
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidOpt(String s) {
        Map<Character, Character> matcher = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (matcher.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || ch != matcher.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
