package com.jysun.practice.category.bit;

/**
 * 颠倒二进制位
 *
 * @author jysun
 * @since 2022/4/19
 */
public class LC190 {
    public static void main(String[] args) {
        // 正数原码，负数补码
        // 5的原码
        // 00000000000000000000000000000101
        System.out.println(Integer.toBinaryString(5));
        // 5的反码
        // 11111111111111111111111111111010
        // 5的补码
        // 11111111111111111111111111111011
        System.out.println(Integer.toBinaryString(-5));
        // 5 + -5 = 0
        // 00000000000000000000000000000101
        // 11111111111111111111111111111011
        //100000000000000000000000000000000 溢出为0

        System.out.println(new LC190().reverseBits(5));
        System.out.println(Integer.reverse(5));
        System.out.println(new LC190().reverse(5));

        // 11111111111111111111111111111101
        System.out.println(-5 >> 1);
        // 01111111111111111111111111111101
        System.out.println(-5 >>> 1);
        // 01111111111111111111111111111101
        System.out.println(Integer.toBinaryString(2147483645));
    }

    public int reverse(int n) {
        // 相邻bit交换
        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
        // 每相邻2bit交换
        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
        // 每相邻4bit交换
        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
        // 每相邻8bit交换
        n = (n & 0x00ff00ff) << 8 | (n >>> 8) & 0x00ff00ff;
        // 最后16bit交换
        return n << 16 | n >>> 16;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // 从左往右高位替代到低位进行位运算累加
        for (int i = 0; i < 32; i++) {
            // n & 1为最低bit位挪到最高位累加
            res |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return res;
    }
}
