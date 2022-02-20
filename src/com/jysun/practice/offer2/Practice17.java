package com.jysun.practice.offer2;

/**
 * 打印从1到最大的n位数
 *
 * @author json
 * @since 2022/2/20
 */
public class Practice17 {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        int max = 1;
        // 先找最大的n位十进制数
        while (n-- > 0) {
            max *= 10;
        }
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
