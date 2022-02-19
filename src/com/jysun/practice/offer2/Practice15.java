package com.jysun.practice.offer2;

/**
 * 二进制中1的个数
 *
 * @author json
 * @since 2022/2/19
 */
public class Practice15 {

    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        // 想下什么数和1做操作可以区分出来有没有，当然是与了。1&1=1, 1&0=0
        // 所以拿n的每一位和1做&，1不断左移
        int res = 0;
        int t = 1;
        while (t != 0) {
            // 就某一位为1，其他都为1，如果那一位是1就说明&结果不为0
            if ((n & t) != 0) {
                res++;
            }
            t <<= 1;
        }
        return res;
    }

    public int solution(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                res++;
            }
        }
        return res;
    }

    public int solution1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            // n & (n - 1) 其结果会把二进制位中的最低位的 1 变为 0 之后的结果
            // 所以只要n不为0，与n-1做完与操作后就说明低位有1
            n = n & (n-1);
        }
        return res;
    }
}
