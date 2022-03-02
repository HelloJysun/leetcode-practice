package com.jysun.practice.offer2;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author jysun
 * @since 2022/3/2
 */
public class Practice39 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Practice39().majorityElement(nums));
    }

    /**
     * 粗暴做法：哈希统计、排序取中间
     * 取巧：pk，随机选取一个基准数，相当于血量为1，依次与后续元素pk，相等就+1，不等就-1，血量降为0就置换下一位
     */
    public int majorityElement(int[] nums) {
        int pivot = nums[0];
        int blood = 1;
        for (int i = 1; i < nums.length; i++) {
            if (pivot == nums[i]) {
                blood++;
            } else if (blood == 1) {
                pivot = nums[i];
            } else {
                blood--;
            }
        }
        // 如果不一定存在，则需要加入验证环节，即再次遍历一遍统计该pivot是否大于数组长度一半
        return pivot;
    }
}
