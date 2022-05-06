package com.jysun.practice.category.bit;

/**
 * 二进制表示中质数个数置位
 *
 * @author jysun
 * @since 2022/4/5
 */
public class LC762 {
    public static void main(String[] args) {
        // 110 & 101
        System.out.println(new LC762().clearLowBit(6));
        // 110 &
        System.out.println(new LC762().lowBit1(6));

        System.out.println(new LC762().countPrimeSetBits(6, 10));
    }

    /**
     * 消除最右边bit 1的值
     */
    public int clearLowBit(int num) {
        return num & (num - 1);
    }

    /**
     * 取最右边的bit 1的值
     */
    public int lowBit1(int num) {
        return num & -num;
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            int num = countBits(i);
            if (isPrime(num)) {
                res++;
            }
        }
        return res;
    }

    public int countBits(int num) {
        int cnt = 0;
        while (num != 0) {
            num -= num & -num;
            cnt++;
        }
        return cnt;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return num >= 2;
    }
}
