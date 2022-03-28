package com.jysun.practice.offer2.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author json
 * @since 2022/3/16
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 4, 1, 3, 7};
        System.out.println(Arrays.toString(new MergeSort().merge(nums)));
    }

    /**
     * 归并排序和快速排序都是基于分治思想
     * 区别在于，归并排序自下而上，先不断向下分割数组到单个元素，然后再两两合并往上返回
     */
    public int[] merge(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + right >> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    int[] tmp;

    /**
     * 这里left - mid相对有序
     * mid + 1 - right也是有序
     * 所以需要合并left - right范围内元素
     */
    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        int p = left;
        // 这里要么就依次轮流防止两个数组元素，直到一方遍历完再放剩下的
        while (i <= mid && j <= right) {
            if (tmp[i] <= tmp[j]) {
                nums[p++] = tmp[i++];
            } else {
                nums[p++] = tmp[j++];
            }
        }
        while (i <= mid) {
            nums[p++] = tmp[i++];
        }
        while (j <= right) {
            nums[p++] = tmp[j++];
        }
    }
}
