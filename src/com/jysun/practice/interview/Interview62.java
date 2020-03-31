package com.jysun.practice.interview;

import java.util.ArrayList;

/**
 * @author Jysun
 * @description Interview62圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @date 2020/3/31 22:10
 */
public class Interview62 {

    public static void main(String[] args) {
        Interview62 obj = new Interview62();
        System.out.println(obj.lastRemaining(5, 2));
        System.out.println(obj.lastRemainingOpt(5, 2));
    }

    /**
     * 环状链表（循环数组）模拟操作
     * 执行用时 :1173 ms, 在所有 Java 提交中击败了8.17%的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * 不管是链表还是数据remove第index个数操作都是O(n)时间复杂度
     * 结合一共要remove n-1个元素，综合时间复杂度为O(n2)
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * 从 n = 1 情况依次推断处 n 的情况
     * m = 3
     * n = 5 时  0 1 2 3 4 (0 1 2 3 4) 移除 2，将后续元素左移 3 位
     * n = 4 时  3 4 0 1 (3 4 0 1) 移除 0，将后续元素左移 3 位
     * n = 3 时  1 3 4 (1 3 4) 移除 4，依次类推
     * ...
     * n = 1 时 3
     * 从下往上推断。相当于每次时将元素右移 3 位再对当前数取模
     * f(5) = (f(4) + 3) % 5
     * f(4) = (f(3) + 3) % 4
     * 动态规划：
     * dp[i] = (dp[i - 1] + m) % i
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingOpt(int n, int m) {
        int index = 0;
        for (int i = 1; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}
