package com.jysun.practice.medium;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * @author jysun
 * @since 2022/4/22
 */
public class Medium75 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Medium75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 202110
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, index = 0;
        while (index < right) {
            if (nums[index] == 0) {
                // 为0就与左边界交换，left右移，index处已经为0最小了可以右移
                swap(nums, index++, left++);
            } else if (nums[index] == 1) {
                // 为1说明该元素就在中间，index后移即可
                index++;
            } else if (nums[index] == 2) {
                // 为2就与右边界交换。交换过来的有可能不是0所以index停在原地
                swap(nums, index, right--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
