package com.jysun.practice.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * topK
 *
 * @author jysun
 * @since 2022/2/13
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int k = 4;
        int[] res = getLeastNumbers2(arr, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 堆排
     * 维护一个大小为k的最大堆，堆顶为最大元素，不断遍历直到结束
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        if (arr.length == 0 || k == 0) {
            return res;
        }
        // 倒序的优先队列其实就是一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 快排
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    public static int[] quickSort(int[] arr, int l, int r, int k) {
        int p = partition(arr, l, r);
        // p下标左边的都是小于arr[p]的数
        if (p == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        // 基准下标大于k时，说明前k个元素在左边，否则在右边
        return p > k ? quickSort(arr, l, p - 1, k) : quickSort(arr, p + 1, r, k);
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }
        // 此时l与r相等，把pivot填充回去
        arr[l] = pivot;
        return l;
    }
}
