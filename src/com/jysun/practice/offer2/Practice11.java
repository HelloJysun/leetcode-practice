package com.jysun.practice.offer2;

/**
 * 旋转数组的最小数字
 *
 * @author json
 * @since 2022/2/17
 */
public class Practice11 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public int solution(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (numbers[mid] > numbers[right]) {
                // 中间大于右侧，左侧有序，在右侧
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 中间小于右侧，右侧有序，在左侧有可能mid是
                right = mid;
            } else {
                // 中间和右侧相等，重复元素情况或者mid就是，那就缩小重复范围
                right--;
            }
        }
        return numbers[left];
    }
}
