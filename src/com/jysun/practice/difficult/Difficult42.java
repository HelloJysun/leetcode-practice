package com.jysun.practice.difficult;

import java.util.Stack;

/**
 * @author Jysun
 * @description Difficult42 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @date 2020/4/19 17:45
 */
public class Difficult42 {

    public static void main(String[] args) {
        Difficult42 obj = new Difficult42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap(height));
        System.out.println(obj.trapDp(height));
        System.out.println(obj.trapDpDouble(height));
        System.out.println(obj.trapStack(height));
    }

    /**
     * 每根柱子上边可以存储的水量为 左右最大柱子的较小者 - 当前柱子高
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lMax = 0, rMax = 0;
            // 当前柱子左侧最高柱子
            for (int j = 0; j <= i; j++) {
                lMax = Math.max(lMax, height[j]);
            }
            // 当前柱子右侧最高柱子
            for (int j = i; j < height.length; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

    /**
     * dp，记录暴力破解当前柱子的左侧和右侧最高柱子
     * @param height
     * @return
     */
    public int trapDp(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[][] dp = new int[height.length][2];
        // 记忆化生成第 i 根柱子的左侧最高
        dp[0][0] = height[0];
        dp[height.length - 1][1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }

    /**
     * 双指针。dp解法中数组存储了当前柱子的左侧最大值和右侧最大值
     * 那完全可以使用双指针从左右出发，使用两个临时变量存储其左右最大值
     * Math.min(leftMax, rightMax) - height[i]
     *
     *
     * @param height
     * @return
     */
    public int trapDpDouble(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, res = 0;
        while (left <= right) {
            if (leftMax <= rightMax) { // 左侧为较小者
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            }
        }
        return res;
    }

    /**
     * 维护一个单调递减栈
     * 元素小于栈顶元素，说明无法形成水槽
     * 元素大于栈顶元素，说明可以形成水槽，此时弹出栈中小于的元素，并且要确保左侧还有元素，否则就是平的
     *
     * @param height
     * @return
     */
    private int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIdx = stack.pop(); // 底部下标
                while (!stack.isEmpty() && height[bottomIdx] == height[stack.peek()]) { // 有和底部相平的柱子弹出
                    stack.pop();
                }
                if (!stack.isEmpty()) { // 此时栈不为空，说明左侧还有较高的柱子挡着，可以形成水槽
                    // 形成的水槽面积 = (底部下标的左右侧较小柱 - 底部下标柱子) * (底部下标的右侧下标 - 底部下标的左侧下标 - 1)
                    res += (Math.min(height[i], height[stack.peek()]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
