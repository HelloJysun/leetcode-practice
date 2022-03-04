package com.jysun.practice.offer2.sort;

import java.util.Arrays;

/**
 * @author jysun
 * @since 2022/3/2
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new QuickSort().quickSort(arr)));
    }

    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int tL = left;
            int tR = right;
            // 相当于把left挖了个坑
            int pivot = arr[left];
            while (left < right) {
                // 找小于基准数的并交换。相当于把right处值填到left挖的坑，此时right坑需要后边来填
                while (left < right && arr[right] > pivot) {
                    right--;
                }
                if (left < right) {
                    arr[left] = arr[right];
                    left++;
                }
                while (left < right && arr[left] < pivot) {
                    left++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                    right--;
                }
            }
            arr[left] = pivot;
            quickSort(arr, tL, left - 1);
            quickSort(arr, left + 1, tR);
        }
    }
}
