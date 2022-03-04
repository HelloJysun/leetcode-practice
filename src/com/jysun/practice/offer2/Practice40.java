package com.jysun.practice.offer2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的K的数
 *
 * @author jysun
 * @since 2022/3/2
 */
public class Practice40 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(new Practice40().getLeastNumbers(arr, 4)));
        System.out.println(Arrays.toString(new Practice40().solution(arr, 4)));
        System.out.println(Arrays.toString(new Practice40().getLeastNumbersSort(arr, 4)));
    }

    /**
     * TopK问题经典解法：排序后取前K个数、维护大小为K的堆
     * 如果规定了数组中元素大小，那也可以用计数排序统计后再从左往右取元素
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        // 维护大小为k的前k小的值的大顶堆（即堆顶为最大元素）
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        // 依次比较堆顶，碰到比堆顶小的就把堆顶弹出
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }

    public int[] solution(int[] arr, int k) {
        int[] entry = new int[10001];
        for (int j : arr) {
            entry[j]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i] == 0) {
                continue;
            }
            while (entry[i]-- > 0) {
                res[idx++] = i;
                if (idx == k) {
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 快排做法：根据分治时传入的pivot下标判断是否等于k，等于k直接就return前半部分数组就完事了
     * 从右往左遍历找到比基准数小的交换，从左往右找比基准数大的交换，直到二者相遇就返回此时该下标处左侧小于该基准数，右侧大于该基准数
     * 再分治左右两侧数组：[0, pivot - 1] [pivot + 1, arr.length - 1]
     */
    public int[] getLeastNumbersSort(int[] arr, int k) {
        if (k == 0) return new int[0];
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSort(int[] arr, int left, int right, int k) {
        int pivotIndex = quickSort(arr, left, right);
        // 一旦分界点等于k直接截取前k个元素数组，这里有个问题：就是如果数组大小为k，又要取k个数，那其实下标应该是k-1的，否则会越界，所以传进来的k应该要-1，相应的截取也要+1
        if (pivotIndex == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        // 此时pivotIndex值处于正确位置，分治左右两侧数组
        // pivotIndex如果大于k那就是左半边，否则右半边
        return pivotIndex > k ? quickSort(arr, left, pivotIndex - 1, k) : quickSort(arr, pivotIndex + 1, right, k);
    }

    public int quickSort(int[] arr, int left, int right) {
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
        // 返回相对arr[left]基准数排完序后的基准数下标
        arr[left] = pivot;
        return left;
    }
}
