package com.jysun.practice.competition;

import java.util.Arrays;

/**
 * @author Jysun
 * @description 力扣杯20秋季编程赛
 * @date 2020/9/13 9:45
 */
public class LCCUP20Autumn {

    public static void main(String[] args) {
        LCCUP20Autumn obj = new LCCUP20Autumn();



        int[] staple = {10, 20, 5};
        int[] drinks = {5, 5, 2};
        System.out.println(obj.breakfastNumber(staple, drinks, 15));
    }

    /**
     * 给定 x = 1，y = 0
     * "A" 运算：使 x = 2 * x + y；
     * "B" 运算：使 y = 2 * y + x。
     * 解析指令依次计算，返回 x + y 和
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int x = 1, y = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                x = 2 * x + y;
            } else if (ch == 'B') {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    /**
     * 俩数组取一个数字，组合值<=x。staple = [10,20,5], drinks = [5,5,2], x = 15
     * 共有多少种情况
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     *
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);

        int res = 0, d = drinks.length - 1;
        for (int s : staple) {
            while (d >= 0 && drinks[d] + s > x) {
                d--;
            }
            res += d + 1;
        }
        int mod = (int) 1e9 + 7;
        return res % mod;
    }

    public int minimumOperations(String leaves) {


        return -1;
    }
}
