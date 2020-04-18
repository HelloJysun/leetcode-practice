package com.jysun.practice.medium;

/**
 * @author Jysun
 * @description Medium11 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @date 2020/4/18 22:20
 */
public class Medium11 {

    public static void main(String[] args) {
        Medium11 obj = new Medium11();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(obj.maxArea(heights));
        System.out.println(obj.maxAreaOpt(heights));
    }

    /**
     * 暴力解法，穷举两根柱子所有装水值
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 两根柱子取较矮 x 跨越区间
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    /**
     * 双指针解法，左右指针朝中间移动，每次计算最大值后挪动较小的柱子朝里压缩，直到两个指针相遇
     * 双指针耗时 4 ms 穷举耗时 434 ms
     * @param height
     * @return
     */
    public int maxAreaOpt(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
