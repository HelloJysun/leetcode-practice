package com.jysun.practice.simple;

/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * @author json
 * @since 2021/7/8
 */
public class Simple9 {

    public static void main(String[] args) {
        Simple9 obj = new Simple9();
        System.out.println(obj.isPalindrome(121));
        System.out.println(obj.isPalindrome(11));
        System.out.println(obj.isPalindrome(-121));
        System.out.println(obj.isPalindrome(0));
        System.out.println("=======opt=======");
        System.out.println(obj.isPalindromeOpt(121));
        System.out.println(obj.isPalindromeOpt(11));
        System.out.println(obj.isPalindromeOpt(-121));
        System.out.println(obj.isPalindromeOpt(0));
    }

    /**
     * 字符串双指针 or 字符串翻转比较
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String s = String.valueOf(x);
        int lo = 0, hi = s.length() - 1;
        while (s.charAt(lo) == s.charAt(hi)) {
            if (lo++ >= hi--) {
                return true;
            }
        }
        return lo >= hi;
    }

    /**
     * 既然是回文数，那么依次取低位累乘10相当于高低位互换比较大小即可
     * @param x
     * @return
     */
    public boolean isPalindromeOpt(int x) {
        if (x < 0) {
            return false;
        }
        int r = 0, t = x;
        while (t != 0) {
            int h = t % 10;
            r = r * 10 + h;
            t = t / 10;
        }
        return r == x;
    }
}
