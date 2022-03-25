package com.jysun.practice.category.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author jysun
 * @since 2022/3/24
 */
public class LC46 {

    public static void main(String[] args) {
        // 不含重复数字的数组，返回所有可能排列方式
        int[] nums = {1, 3, 5};
        System.out.println(new LC46().permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 回溯法：
     * 1、从数组每个位置作为首元素出发递归
     * 2、递归后再从头开始遍历，通过回溯集合判断是否添加或者通过标记数组下标判断
     * 3、前一轮遍历返回后，需要剔除上一轮最后一个元素
     * 4、一旦回溯集合大小达到待放入的集合数就放进排列集合中
     * 抽象：
     * 既然有递归，必然有终止条件，一旦触发直接返回
     * 1、先根据访问与否做选择，访问过就跳过，没访问就丢进回溯集合
     * 2、递归进入下一层决策树
     * 3、弹出回溯集合最后一个元素相当于取消选择
     *
     * @param nums  数组
     * @param track 回溯集合
     */
    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
