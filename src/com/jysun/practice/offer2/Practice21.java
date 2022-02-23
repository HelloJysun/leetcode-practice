package com.jysun.practice.offer2;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author json
 * @since 2022/2/23
 */
public class Practice21 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new Practice21().exchange(nums)));
    }

    /**
     * 奇数在前，偶数在后。关键判断点在 (nums[left] & 1) == 1 这里
     * 如果再拓展出负数在前，非负数在后或者能被3整除在前，不能被3整除在后
     * 那其实可以把这一块统一抽取出来
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && left(nums[left])) {
                left++;
            }
            while (left < right && !left(nums[right])) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = tmp;
            }
        }
        return nums;
    }

    private boolean left(int num) {
        return (num & 1) == 1;
    }
}
