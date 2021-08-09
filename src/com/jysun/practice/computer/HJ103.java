package com.jysun.practice.computer;

import java.util.Scanner;

/**
 * @author Jysun
 * @description HJ103
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
 *
 * 样例输入
 * 6
 * 2 5 1 5 4 5
 * 样例输出
 * 3
 *
 * 提示
 * Example:
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 *
 * 所以这个结果是3。
 * 接口说明
 *
 * 方法原型：
 *
 *     int GetResult(int num, int[] pInput, List  pResult);
 *
 * 输入参数：
 *    int num：整数，表示数组元素的个数（保证有效）。
 *    int[] pInput: 数组，存放输入的数字。
 *
 * 输出参数：
 *    List pResult: 保证传入一个空的List，要求把结果放入第一个位置。
 * 返回值：
 *   正确返回1，错误返回0
 * @date 2020/6/17 7:46
 */
public class HJ103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] input = new int[num];
        for (int i = 0; i < num; i++) {
            input[i] = sc.nextInt();
        }

        int n = 30;
        int[] in = {186, 13, 322, 264, 328, 110, 120, 73, 20, 35, 240, 97, 150, 221, 284, 324, 46, 219, 239, 284, 128, 251, 298, 319, 304, 36, 144, 236, 163, 122};
        System.out.println(GetResult(n, in));
    }

    public static int GetResult(int num, int[] pInput) {
        int[] dp = new int[num];
        for (int i = 0; i < num; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pInput[j] < pInput[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = dp[0];
        for (int i = 1; i < num; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
