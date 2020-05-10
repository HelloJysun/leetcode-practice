package com.jysun.practice.simple;

/**
 * @author Jysun
 * @description Simple69 x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @date 2020/5/10 8:54
 */
public class Simple69 {
    public static void main(String[] args) {
        Simple69 obj = new Simple69();
        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(8));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0;
        int high = x;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                low = mid + 1; // 左中位数收缩 low 记得 +1
            } else {
                high = mid;
            }
        }
        return low - 1;
    }
}
