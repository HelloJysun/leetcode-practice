package com.jysun.practice.offer2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 *
 * @author json
 * @since 2022/5/12
 */
public class Practice59 {

    /**
     * 虽然每次向右滑动一位窗口，但整个窗口中元素多了右侧元素，且少了左侧元素
     * 如果只是多了右侧元素，那么维护一个最大值比较即可，但少了左侧元素后就需要遍历整个窗口元素判断最大值
     * 所以这个滑动窗口在需要动态维护在一个队列中，其中这个队列可以压入元素，弹出元素，还可以找出队列中的最大值
     * 如果该窗口内元素小于待压入元素，就可以说明该窗口内不可能有比该元素还大的，所以需要将比该元素小的数弹出
     * 确保该队列中维护的是一个单调递减序列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        // 返回值共有nums.length - k + 1个
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 先找出第一个窗口最大值，并维护左右边界下标
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[index++] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            // 队头元素和待移除元素相等就队头出队
            if (nums[i - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            // 通用维护单调递减栈代码，队尾元素小于待入队元素时，就持续出队直到大于待插入元素，从而维护单调递减特性
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[index++] = queue.peekFirst();
        }
        return res;
    }
}
