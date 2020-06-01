package com.jysun.practice.interview;

/**
 * @author Jysun
 * @description Interview64 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *
 * @date 2020/6/2 7:51
 */
public class Interview64 {

    public static void main(String[] args) {
        Interview64 obj = new Interview64();
        System.out.println(obj.sumNums(10));
    }

    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
