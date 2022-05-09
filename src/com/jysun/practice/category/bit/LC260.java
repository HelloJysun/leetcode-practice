package com.jysun.practice.category.bit;

import java.util.Arrays;

/**
 * 只出现一次的数字 III
 *
 * @author jysun
 * @since 2022/5/9
 */
public class LC260 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(new LC260().singleNumber(nums)));
    }

    /**
     * 由于只有两个数出现一次，其余均出现两次，如果对所有数做异或则最终得到出现一次的数异或后的结果
     * 而异或运算最终结果比特位为1肯定是两个出现一次的数一个为1，一个为0形成的所以可以利用这一特性将二者区分开
     */
    public int[] singleNumber(int[] nums) {
        // 1.xor结果
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 2.随便找到一个bit为1的位
        int index = 1;
        while ((xor & index) == 0) {
            index <<= 1;
        }
        int[] res = new int[2];
        // 3.将原数与该bit位1做与运算得到第index位数值分组
        for (int num : nums) {
            if ((num & index) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
