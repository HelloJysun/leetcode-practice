package com.jysun.practice.medium;

import java.util.Arrays;

/**
 * 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @author json
 * @since 2021/8/4
 */
public class Medium611 {

    public static void main(String[] args) {
        Medium611 obj = new Medium611();
        int[] nums = {2, 2, 3, 4};
        System.out.println(obj.triangleNumberSort(nums));
        int[] nums2 = {0, 7, 0, 0};
        System.out.println(obj.triangleNumberSort(nums2));
    }

    /**
     * timeout
     */
    public int triangleNumber(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k]
                            && nums[i] + nums[k] > nums[j]
                            && nums[j] + nums[k] > nums[i]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int triangleNumberSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int l = j + 1;
                int r = len - 1;
                int cnt = nums[i] + nums[j];
                while (l < r) {
                    int m = l + r + 1 >>> 1;
                    if (cnt > nums[m]) {
                        l = m;
                    } else {
                        r = m - 1;
                    }
                }
                if (cnt > nums[r]) {
                    res = res + r - j;
                }
            }
        }
        return res;
    }
}
