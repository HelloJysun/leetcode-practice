package com.jysun.practice.offer;

/**
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：
 * 0 <= num < 2^31
 *
 * @author jysun
 * @since 2021/8/19
 */
public class Offer46 {

    public static void main(String[] args) {
        Offer46 obj = new Offer46();
        System.out.println(obj.translateNum(12258));
        System.out.println(obj.translateNum(1068385902));
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        // dp[i] 表示，从右往左数，第i个字符到最右边可以组成几种情况
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            // num % 10取单个余数，% 100取两个余数
            // 右移的两位数，如果位于[10, 25]说明可以和前边的数组成一种情况
            // 所以i字符到最右边情况有去除一位和去除两位字符的可能
            int n = num % 100;
            if (n >= 10 && n < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
            num = num / 10;
        }
        return dp[s.length()];
    }
}
