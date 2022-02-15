package com.jysun.practice.practice;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author jysun
 * @since 2022/2/13
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int l, int r) {
        if (l < r) {
            // 以data[p]为基准，此时左侧全部小于data[p]，右侧全部大于data[p]
            int p = partition(data, l, r);
            // 分治左右
            quickSort(data, l, p - 1);
            quickSort(data, p + 1, r);
        }
    }

    private static int partition(int[] data, int l, int r) {
        // 取最左侧为基准值，相当于挖的第一个坑l
        int pivot = data[l];
        while (l < r) {
            // 从右往左找第一个小于pivot的数填l坑，这里必须要有等于，防止相同的数原地打转死循环！！！
            while (l < r && data[r] >= pivot) {
                r--;
            }
            // r位置数填到l处，相当于r又挖了个坑
            data[l] = data[r];
            // 从左往右找第一个大于pivot的数填在r坑处
            while (l < r && data[l] <= pivot) {
                l++;
            }
            data[r] = data[l];
        }
        // 第一轮跑完后，此时l与r相遇，将一开始的数填在该处，并返回基准下标
        // 例如：72, 6, 57, 88, 60, 42, 83, 73, 48, 85
        // 选取基准值72，第一轮跑完后为
        // 48, 6, 57, 42, 60, 72, 83, 73, 88, 85
        data[l] = pivot;
        return l;
    }
}
