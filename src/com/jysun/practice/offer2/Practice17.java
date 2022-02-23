package com.jysun.practice.offer2;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 *
 * @author json
 * @since 2022/2/20
 */
public class Practice17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Practice17().printNumbers(1)));
        System.out.println(Arrays.toString(new Practice17().printNumbers(2)));
        System.out.println(Arrays.toString(new Practice17().printNumbers(3)));
    }

    int index = 0;

    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int length = 1; length < n + 1; length++) {
            char[] num = new char[length];
            for (char i = '1'; i <= '9'; i++) {
                num[0] = i;
                dfs(res, num, length, 0);
            }
        }
        return res;
    }

    public void dfs(int[] res, char[] num, int length, int i) {
        if (length == i + 1) {
            res[index++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for (char j = '0'; j <= '9'; j++) {
            num[i + 1] = j;
            dfs(res, num, length, i + 1);
        }
    }
}
