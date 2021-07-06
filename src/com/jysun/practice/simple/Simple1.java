package com.jysun.practice.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * @author json
 * @since 2021/7/6
 */
public class Simple1 {

    public static void main(String[] args) {
        Simple1 obj = new Simple1();
        int[] nums = {2, 7, 11, 15};
        int[] res = obj.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 遍历一遍数组即可，遍历当前元素相当于寻找 target - cur
     * 如果存在则直接返回 cur下标和 target - cur 的下标即可
     * 否则将当前元素下标放进哈希表
     *
     * @param nums   nums
     * @param target target
     * @return res
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (data.containsKey(target - nums[i])) {
                return new int[]{data.get(target - nums[i]), i};
            }
            data.put(nums[i], i);
        }
        return new int[0];
    }
}
