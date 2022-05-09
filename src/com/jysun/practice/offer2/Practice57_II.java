package com.jysun.practice.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * @author jysun
 * @since 2022/5/9
 */
public class Practice57_II {

    public static void main(String[] args) {
        int[][] res = new Practice57_II().findContinuousSequence(9);
        for (int[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }

    /**
     * 枚举
     * 要求至少两个数的和 == target所以这两个数最大不超过 target/2
     * 奇数情况，默认向下取整
     * 偶数情况，则不符合题意
     * 综合统一默认向下取整判断
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 0, limit = (target - 1) / 2;
        for (int i = 1; i <= limit; i++) {
            // 从i开始不断枚举连续子序列和
            for (int j = i; ; j++) {
                sum += j;
                // 一旦超过目标值就重置从i+1开始枚举
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] item = new int[j - i + 1];
                    int idx = 0, cur = i;
                    while (cur <= j) {
                        item[idx++] = cur++;
                    }
                    res.add(item);
                }
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] findContinuousSequenceOpt(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 2, sum = 3;
        while (left < right) {
            if (sum == target) {
                int[] item = new int[right - left + 1];
                int idx = 0, cur = left;
                while (cur <= right) {
                    item[idx++] = cur++;
                }
                res.add(item);
            }
            if (sum < target) {
                // 小于目标值扩大右边界
                right++;
                sum += right;
            } else {
                // 大于目标值收缩左边界
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
