package com.jysun.practice.simple;

/**
 * @author json
 * @since 2021/8/20
 */
public class Simple541_ {

    public static void main(String[] args) {
        String res = new Simple541_().reverseStr("abcdefgh", 3);
        System.out.println(res);
    }

    public String reverseStr(String s, int k) {
        char[] data = s.toCharArray();
        int len = s.length();
        int lo = 0, hi = k - 1;
        while (lo < len) {
            // 剩余字符小于k个
            if (hi >= len) {
                hi = len - 1;
            }
            swap(lo, hi, data);
            lo += 2 * k;
            hi += 2 * k;
        }
        return new String(data);
    }

    private void swap(int lo, int hi, char[] data) {
        while (lo < hi) {
            char tmp = data[lo];
            data[lo++] = data[hi];
            data[hi--] = tmp;
        }
    }

}
