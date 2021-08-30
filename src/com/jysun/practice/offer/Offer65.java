package com.jysun.practice.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author json
 * @since 2021/8/30
 */
public class Offer65 {

    public static void main(String[] args) {
        Offer65 obj = new Offer65();
        System.out.println(obj.add(5, 17));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
