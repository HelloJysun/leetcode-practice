package com.jysun.practice.category.bit;

/**
 * 位1的个数
 *
 * @author jysun
 * @since 2022/4/19
 */
public class LC191 {
    public static void main(String[] args) {
        // 11111111111111111111111111111011
        System.out.println(Integer.bitCount(-5));
        System.out.println(new LC191().hammingWeight(-5));
        System.out.println(new LC191().bitCount(-5));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // 1、n & (n - 1)消除最低bit1
//            n &= (n - 1);
//            res++;
            // 2、n & -n 获取最低bit1的十进制值
            n -= (n & -n);
            res++;
        }
        return res;
    }

    /**
     * 按位统计（Integer32bit表示）
     * 1、相邻bit统计
     * 2、相邻2bit统计
     * ...
     * 5、相邻16bit统计
     * 比如相邻4bit累加 0101 & 0101 = 1010 即 5 + 5 = 10
     */
    public int bitCount(int n) {
        // 低1位 & 高1位
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        return (n & 0x0000ffff) + (n >>> 16 & 0x0000ffff);
    }
}
