package com.jysun.practice.offer;

/**
 * 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：
 * 1 <= n <= 10000
 *
 * @author json
 * @since 2021/8/29
 */
public class Offer64 {

    public static void main(String[] args) {
        Offer64 obj = new Offer64();
        System.out.println(obj.sumNums(9));
    }

    /**
     * 计算 f(n) 相当于 n + f(n - 1)
     * 依次类推直到 n == 0 返回 0
     * 由于不能使用 if 等关键字，所以要想办法把 if (n == 0) return 0 替换掉
     */
    public int sumNums(int n) {
        boolean f = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
