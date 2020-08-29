package com.jysun.practice.practice.string;

import java.util.Arrays;

/**
 * @author Jysun
 * @description
 * @date 2020/8/25 11:11
 */
public class KMP {

    public static void main(String[] args) {
        KMP obj = new KMP();
        System.out.println(obj.matcher("ABABABABCABAACD", "ABABCABAA"));
    }

    /**
     * 构造prefix table数组
     *
     * @param T 模式串
     * @return prefix table
     */
    private int[] prefixTable(String T) {
        int[] prefix = new int[T.length()];
        // len记录的是
        int len = 0;
        for (int i = 1; i < T.length(); i++) {
            while (len > 0 && T.charAt(i) != T.charAt(len)) {
                len = prefix[len - 1];
            }
            if (T.charAt(i) == T.charAt(len)) {
                len++;
            }
            prefix[i] = len;
        }
        return prefix;
    }

    private int[] nextTable(int[] prefix) {
        int[] next = new int[prefix.length];
        next[0] = -1;
        for (int i = 1; i < next.length; i++) {
            next[i] = prefix[i - 1];
        }
        return next;
    }

    public int matcher(String S, String T) {
        int[] prefixTable = prefixTable(T);
        int[] nextTable = nextTable(prefixTable);
        System.out.println(Arrays.toString(nextTable));
        int i = 0, j = 0;
        while (i < S.length()) {
            if (j == T.length() - 1 && S.charAt(i) == T.charAt(j)) {
                return i - j;
                // 多个匹配时，j移动接着匹配 j = nextTable[j]
            }
            if (S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else {
                // 此时i,j位置字符不同，模式串右移相当于j移动到已匹配前缀处
                j = nextTable[j];
                // 边界-1情况，二者同时右移
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }
}
