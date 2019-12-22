package com.jysun.practice.simple;

/**
 * @author Jysun
 * @description
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @date 2019/12/22 9:34
 */
public class Simple26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 5, 6};
        int i = removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.printf(nums[j] + " ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        // 定义一个光标变量，用于记录当前元素插入位置
        int idx = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            // 当前元素不等于前一个元素，将元素赋值给idx光标处
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        // 长度即为光标值
        return idx;
    }
}
