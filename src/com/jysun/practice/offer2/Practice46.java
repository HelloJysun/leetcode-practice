package com.jysun.practice.offer2;

/**
 * 把数字翻译成字符串
 *
 * @author jysun
 * @since 2022/3/4
 */
public class Practice46 {

    public static void main(String[] args) {
        System.out.println(new Practice46().translateNum(12258));
    }

    /**
     * 0a 1b 2c ... 25z
     * 以12258举例，12258可由1225 8或122 58二者得来
     * 由翻译表可知单个数字均可翻译为字母，所以只需考虑2个数字组合数是否在[0, 25]即可
     * 如果两位数可以翻译就是
     * dp[i] = dp[i - 2] + dp[i - 1]
     * 如果不可以翻译就是
     * dp[i] = dp[i - 1]
     * 其实还是青蛙跳台阶问题，区别在于跳2步时需要看是否符合条件
     */
    public int translateNum(int num) {
        int b = 1, a = 1;
        int y = num % 10;
        // 12258从右往左取余判断
        while (num != 0) {
            num /= 10;
            int x = num % 10;
            // 两位数组合
            int s = 10 * x + y;
            int c = (s >= 10 && s <= 25) ? b + a : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
