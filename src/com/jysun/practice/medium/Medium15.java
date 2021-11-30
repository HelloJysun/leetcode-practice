package com.jysun.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author jysun
 * @since 2021/11/30
 */
public class Medium15 {

    public static void main(String[] args) {
        Medium15 obj = new Medium15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSum(nums));
    }

    /**
     * 三数之和等于0，相当于固定一个数a，找剩下两个数b + c = -a
     * 因为找不重复组合，所以可以排序后，直接固定一个数，剩下两个数向右搜索即可。而且三个数不允许重复，b != a && c != a
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 1、第一处去重在于下标i元素的去重，直接判断前后是否相等
        // 2、第二处去重在于固定下标i元素时，剩余两个元素的左右是否相等
        // -4 -1 -1 0 1 2
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 当前数大于0，右边两数再怎么加也不会等于0，没有继续的意义。当前数和前一个数一样遍历过没有再次遍历的必要
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 问题变为 nums[l] + nums[r] == -sum
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    // 这里会有重复的三个元素情况，需要去重
                    res.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    // 左右边界向内缩直到不等。这个不加[-2,0,0,2,2]用例过不了
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
