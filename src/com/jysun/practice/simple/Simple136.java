package com.jysun.practice.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jysun
 * @description Simple136 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @date 2020/4/18 10:37
 */
public class Simple136 {

    public static void main(String[] args) {
        Simple136 obj = new Simple136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums));
        System.out.println(obj.singleNumberOpt(nums));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 优化解法：
     * 异或 ^ 运算符 - 不同为真，同为假，异或同一个数两次，原数不改变
     * xor 异或满足交换律、结合律
     * a ^ 0 = a
     * a ^ a = 0
     * a ^ b ^ b = a ^ (b ^ b) = a ^ 0 = a
     *
     * @param nums
     * @return
     */
    public int singleNumberOpt(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
