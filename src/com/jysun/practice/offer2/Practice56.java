package com.jysun.practice.offer2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中数字出现的次数
 *
 * @author jysun
 * @since 2022/5/9
 */
public class Practice56 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(new Practice56().singleNumbers(nums)));
    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
}
