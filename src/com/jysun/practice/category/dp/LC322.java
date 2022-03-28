package com.jysun.practice.category.dp;

/**
 * 零钱兑换
 *
 * @author json
 * @since 2022/3/28
 */
public class LC322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new LC322().coinChange(coins, 11));
    }

    /**
     * dp求解：
     * 1、首先定义状态数组，dp[i]表示兑换面额为 i 所需最小硬币数量
     * 2、状态转移方程 dp[i] = min(dp[i - coins[j]]) + 1。需要充分理解dp[i - coins[j]]是需要遍历所有的硬币
     *   例如[1,2,5]组合为11。可以理解为爬11层楼梯可以从i-1/i-2/i-5过来，但是需要取这三个dp[i]的最小值
     *   所以内部可以用for循环遍历硬币数组，并用dp[i]暂存每种硬币对比后的最小情况内部dp[i]不断更新最小值
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示兑换面额 i 所需最小的硬币数量
        // 对于任意金额 j 就是取coins[i]和不取的区别。dp[j] = min(dp[j - coins[i]] + 1, dp[j])
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; j++) { // 背包：amount面额
            dp[j] = max; // 初始化为最大值
            for (int i = 0; i < coins.length; i++) { // 物品：硬币面额
                // dp[j - coins[i]]如果还是max说明不存在
                // 这里注意因为j从1开始，所以存在背包容量小于物品大小
                if (j - coins[i] >= 0 && dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
