package com.jysun.practice.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jysun
 * @description 编程
 * 给定 n 个整数，每次可以从剩下的整数中取走两个整数并计算这两个整数的积。
 * 若该操作进行 m 次，求每次计算的积之和的最小值。
 *
 * Input:
 * 输入一个整数 T 代表测试数据组组数，对于每组数据：
 * 第一行输入两个整数n和m（1 < n < 10^5，0 < m < 0.5n），它们含义如题所述。
 * 第二行输入n个整数 a1, a2, ... an (0 < ai < 10^4) 表示给定的整数
 *
 * Output:
 * 每组数据输出一行一个整数，表示积之和的最小值。
 *
 * Sample:
 * 3
 * 4 2
 * 1 3 2 4
 * 3 1
 * 2 3 1
 * 4 0
 * 1 3 2 4
 * Sample Output / 样例输出
 * 10
 * 2
 * 0
 * @date 2020/9/3 15:25
 */
public class Interview {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] res = new int[i];
        for (int j = 0; j < i; j++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int k = 0; k < n; k++) {
                arr[k] = sc.nextInt();
            }
            res[j] = solution(arr, m);
        }
        for (int j = 0; j < i; j++) {
            System.out.println(res[j]);
        }
    }

    /**
     * 从arr中每次抽两个算乘积，抽 m 次计算最小和
     *
     * @param arr
     * @param m
     * @return
     */
    public static int solution(int[] arr, int m) {
        Arrays.sort(arr);
        int res = 0;
        int l = 0, r = m * 2 - 1;
        for (int i = 0; i < m; i++) {
            res += (arr[l++] * arr[r--]);
        }
        return res;
    }
}
