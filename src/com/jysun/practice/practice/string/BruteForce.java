package com.jysun.practice.practice.string;

/**
 * @author Jysun
 * @description 暴力破解，字符串匹配
 * @date 2020/8/24 17:21
 */
public class BruteForce {

    public static void main(String[] args) {
        BruteForce obj = new BruteForce();
        System.out.println(obj.matcher("abababc", "abc"));
        System.out.println(obj.matcher("abababc", "aaa"));
    }

    /**
     * 思路：将 T 从 S 下标 0 处开始依次比较 T 的每一个字符，全部相等则视为匹配成功
     * 否则将 T 向右挪动 1 位，即从 S 下标 1 处再依次比较，直到挪动到 S.length() - T.length() 处为止
     *
     * @param S 目标串
     * @param T 模式串
     * @return 初始匹配下标
     */
    public int matcher(String S, String T) {
        for (int i = 0; i <= S.length() - T.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                if (S.charAt(i + j) != T.charAt(j)) {
                    break;
                } else if (j == T.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
