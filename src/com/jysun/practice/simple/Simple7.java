package com.jysun.practice.simple;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -231 <= x <= 231 - 1
 *
 * @author json
 * @since 2021/8/22
 */
public class Simple7 {

    public static void main(String[] args) {
        Simple7 obj = new Simple7();
        System.out.println(obj.reverse(-123));
        System.out.println(obj.reverseOpt(123));
        System.out.println(obj.reverseOpt(-123));
        System.out.println(obj.reverseOpt(120));
        System.out.println(obj.reverseOpt(1234567899));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '-') {
                return -res;
            }
            if (res > max) {
                return 0;
            }
            res = res * 10 + c - '0';
        }
        return res;
    }

    public int reverseOpt(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (res > max || res < min) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
