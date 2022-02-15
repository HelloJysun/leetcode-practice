package com.jysun.practice.offer2;

/**
 * 替换空格
 *
 * @author jysun
 * @since 2022/2/15
 */
public class Practice5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        // 自己造轮子
        System.out.println(new Practice5().replaceSpace(s));

        // 现成的轮子啊k
        System.out.println(s.replace(" ", "%20"));
    }

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                res.append(c);
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }
}
