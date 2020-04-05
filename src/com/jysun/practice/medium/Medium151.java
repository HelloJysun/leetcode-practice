package com.jysun.practice.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Jysun
 * @description Medium151 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @date 2020/4/5 22:20
 */
public class Medium151 {

    public static void main(String[] args) {
        Medium151 obj = new Medium151();
        assert Objects.equals(obj.reverseWords1("   a    good     example   "), "example good a") : "error";
        assert Objects.equals(obj.reverseWords2("   a    good     example   "), "example good a") : "error";
    }

    public String reverseWords1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        return String.join(",", list);
    }

    public String reverseWords2(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(Objects.equals(arr[i], "") ? "" : arr[i] + " ");
        }
        return res.length() == 0 ? "" : res.substring(0, res.length() - 1);
    }
}
