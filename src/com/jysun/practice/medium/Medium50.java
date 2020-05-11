package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description Medium50 Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @date 2020/5/11 21:56
 */
public class Medium50 {

    public static void main(String[] args) {
        Medium50 obj = new Medium50();
        System.out.println(obj.myPow(2, 10));
        System.out.println(obj.myPow(2.1, 3));
        System.out.println(obj.myPow(2, -2));
        System.out.println(obj.myPow(1, 2147483647));
        System.out.println(obj.myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        double res = 1;
        long N = n;
        if (N < 0) {
            N = -N;
        }
        while (N > 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return n > 0 ? res : 1 / res;
    }
}
