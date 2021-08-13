package com.jysun.practice.offer;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * @author jysun
 * @since 2021/8/12
 */
public class Offer58 {

    public static void main(String[] args) {
        Offer58 obj = new Offer58();
        System.out.println(obj.reverseLeftWords("abcdefg", 2));
        System.out.println(obj.reverseLeftWords("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
