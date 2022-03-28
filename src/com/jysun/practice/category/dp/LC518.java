package com.jysun.practice.category.dp;

/**
 * 零钱兑换 II
 *
 * @author json
 * @since 2022/3/28
 */
public class LC518 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new LC518().change(11, coins));
    }

    public int change(int amount, int[] coins) {
        // dp[i]为凑面额i的硬币组合数
        // 转移方程为每种硬币的所有可能 dp[i] += dp[i - coins[j]];
        int[] dp = new int[amount + 1];
        dp[0] = 1;// 凑成面额0组合只有1种就是[]
        //
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
