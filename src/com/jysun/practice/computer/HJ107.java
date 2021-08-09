package com.jysun.practice.computer;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Jysun
 * @description HJ107
 * 题目描述
 * •计算一个数字的立方根，不使用库函数
 *
 * 详细描述：
 *
 * •接口说明
 *
 * 原型：
 *
 * public static double getCubeRoot(double input)
 *
 * 输入:double 待求解参数
 *
 * 返回值:double  输入参数的立方根，保留一位小数
 *
 * 输入描述:
 * 待求解参数 double类型
 *
 * 输出描述:
 * 输入参数的立方根 也是double类型
 *
 * 示例1
 * 输入
 * 216
 *
 * 输出
 * 6.0
 * @date 2020/6/16 7:39
 */
public class HJ107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        System.out.println(getCubeRoot(input));
    }

    public static double getCubeRoot(double input) {
        long in = Math.round(input * 1000); // 立方倍增1000=立方根倍增10

        long l = 0, r = in;
        while (l < r) {
            long m = (l + r) >>> 1;
            if (in / m / m > m) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        DecimalFormat format = new DecimalFormat("0.00");
        return Double.valueOf(format.format((double) l / 10));
    }
}
