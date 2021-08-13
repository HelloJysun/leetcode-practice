package com.jysun.practice.offer;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author jysun
 * @since 2021/8/12
 */
public class Offer05 {

    public static void main(String[] args) {
        Offer05 obj = new Offer05();
        System.out.println(obj.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                res.append(ch);
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }
}
