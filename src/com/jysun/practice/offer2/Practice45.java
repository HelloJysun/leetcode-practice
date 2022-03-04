package com.jysun.practice.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数组排成最小的数
 *
 * @author jysun
 * @since 2022/3/3
 */
public class Practice45 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 3, 4, 5, 9};
        System.out.println(new Practice45().minNumber(nums));
    }

    /**
     * 因为拼接最小数，那其实就是比较每位数从高位到低位的最小值
     * 一旦 ab < ba 说明 ab组合较小，避免int数值溢出，直接compareTo字符串即可
     */
    public String minNumber(int[] nums) {
        List<String> data = new ArrayList<>(nums.length);
        for (int num : nums) {
            data.add(String.valueOf(num));
        }
        data.sort((n1, n2) -> (n1 + n2).compareTo(n2 + n1));
        StringBuilder res = new StringBuilder();
        data.forEach(res::append);
        return res.toString();
    }
}