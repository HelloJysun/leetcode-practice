package com.jysun.practice.offer2;

/**
 * 剪绳子
 *
 * @author json
 * @since 2022/2/19
 */
public class Practice14 {

    /**
     * dp解法。长度为n的绳子割i和n-i，求解f(n)相当于求解 f(i) * f(n-i)
     * 所以不同长度绳子都可以从割1、2...n / 2为止，绳子砍一半剩下一半一样的
     */
     public int cuttingRope(int n) {
         if (n == 2) return 1;
         if (n == 3) return 2;
         int[] dp = new int[n + 1];
         dp[1] = 1;
         dp[2] = 2;
         dp[3] = 3;
         for (int i = 4; i <= n; i++) {
             int max = 0;
             for (int j = 1; j <= i / 2; j++) {
                 // 涉及到取余就没办法比大小
                 max = Math.max(max, dp[j] * dp[i - j]) % 1000000007;
             }
             dp[i] = max;
         }
         return dp[n];
     }

    /**
     * 纯找规律，可以发现一个数拆分为3的小数的积最大
     */
    public int solution(int n) {
        // n>3就是找3找2的过程，剩4拆22也就是4，剩5拆23，剩7拆34
        if (n == 2) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            // 结果累乘取余
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) ((res * n) % 1000000007);
    }
}
