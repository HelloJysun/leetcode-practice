package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 * @date 2020/8/23 15:15
 */
public class Medium201 {

    public static void main(String[] args) {
        Medium201 obj = new Medium201();
        System.out.println(obj.rangeBitwiseAnd(5, 7));
        System.out.println(obj.rangeBitwiseAnd(0, 1));
        // Integer.MAX_VALUE
        System.out.println(obj.rangeBitwiseAnd(0, 2147483647));
    }

    /**
     *   0101
     * & 0110
     * x & (x + 1) 时最后一位必定会由1变为0或者0变为1，甚至后几位必定有相反数产生，比如 5 & 6 时后两位产生了相反数，相反数按位与操作必定为0，其有效位仅仅高几位有效
     * 所以当m & m + 1 & ... & n进行连续按位与时，最后会只剩下 n 的前缀部分
     * 而这个前缀部分就是 m 和 n 最长的前缀部分
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for (; m != n; i++) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
}
