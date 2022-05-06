package com.jysun.practice.category.bit;

/**
 * 只出现一次的数字 II
 *
 * @author jysun
 * @since 2022/4/7
 */
public class LC137 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 2, 2, 2};
        System.out.println(new LC137().singleNumber(nums));
    }

    /**
     * 既然其他数字都出现了3次，那对于每个数字来说其每个bit位的值累加后对3取余后必为0
     * 而出现1次的数字，其bit位值累加后，对3取余后为0或1
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            // (num >> i) & 1 取num的第i位bit值累加1，最终和对3取余必为单个数字对应比特位
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
