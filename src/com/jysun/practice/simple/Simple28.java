package com.jysun.practice.simple;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author json
 * @since 2021/7/28
 */
public class Simple28 {

    public static void main(String[] args) {
        Simple28 obj = new Simple28();
        System.out.println("hello".indexOf("ll"));
        System.out.println(obj.strStr("hello", "ll"));
        System.out.println(obj.strStr("aaaaa", "bba"));
        System.out.println(obj.strStr("", ""));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] hA = haystack.toCharArray();
        char[] nA = needle.toCharArray();
        for (int i = 0; i <= hA.length - nA.length; i++) {
            for (int j = 0; j < nA.length; j++) {
                // 只要不等跳出循环，外层右移1位
                if (hA[i + j] != nA[j]) {
                    break;
                }
                // 相等时内层右移1位，当移动到终点时返回下标i
                if (j == nA.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
