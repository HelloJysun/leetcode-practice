package com.jysun.practice.offer2;

/**
 * @author json
 * @since 2022/2/20
 */
public class Practice16 {

    public static void main(String[] args) {
        System.out.println(new Practice16().myPow(2.0, -10));
        System.out.println(new Practice16().solution(2.0, -10));
        System.out.println(new Practice16().solution2(2.0, -10));
    }

    /**
     * 循环累乘没问题。但如果n超大时，会有很多重复计算，这个其实可以用快速幂实现
     * 计算x^n相当于计算(x^n/2)2也就是不断对n进行除2操作，直到n为1
     * 如果n为偶数n/2还好，如果n为奇数n/2还会差一个x，也就是 (x^(n-1)/2)2 * x
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        int res = 1;
        while (n-- > 0) {
            res *= x;
        }
        return flag ? 1.0 / res : res;
    }

    public double solution(double x, int n) {
        if (n == 0) return 1;
        // 兼容n为负数情况
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1.0;
        while (n > 0) {
            // n为奇数特殊处理多一个x，n%2==0可以优化为位运算(奇数最右侧位一定不为1)所以与1等于1就是奇数
            if ((n & 1) == 1) {
                res *= x;
            }
            // x^n = (x^2)^n/2 奇数多一个x
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public double solution2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        // 递归解决，不断递归n直到n为0，但其实-1就算再怎么右移还是-1这里会有死循环，所以我们要对-1进行return
        double res = solution2(x, n >> 1);
        res *= res;
        // 同样奇数多一个x
        if ((n & 1) == 1) res *= x;
        return res;
    }
}
