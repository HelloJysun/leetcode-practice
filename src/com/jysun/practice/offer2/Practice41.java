package com.jysun.practice.offer2;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author jysun
 * @since 2022/3/2
 */
public class Practice41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }

    /**
     * 前半部分数据维护一个大顶堆，后半部分数据维护一个小顶堆
     * 插入数据时需要动态维护两边堆元素趋于平衡
     * 偶数个数据时，中位数就取两个堆顶平分
     * 奇数个数据时，
     */
    static class MedianFinder {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        /** initialize your data structure here. */
        public MedianFinder() {
            this.left = new PriorityQueue<>((n1, n2) -> n2 - n1);
            this.right = new PriorityQueue<>((n1, n2) -> n1 - n2);
        }

        public void addNum(int num) {
            if (left.isEmpty() && right.isEmpty()) {
                left.add(num);
            } else if (left.size() == right.size()) {
                // 大于小顶堆堆顶，就挪到大顶堆
                if (num >= right.peek()) {
                    left.add(right.poll());
                    right.add(num);
                } else {
                    // 这里相当于中位数，直接约定放到左边大顶堆
                    left.add(num);
                }
            } else {
                // 这里是左边比右边多一个元素，如果比左边大顶堆顶元素还小就挪到小顶堆
                if (num <= left.peek()) {
                    right.add(left.poll());
                    left.add(num);
                } else {
                    right.add(num);
                }
            }
        }

        public double findMedian() {
            if (left.isEmpty()) {
                return 0;
            }
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return left.peek();
            }
        }
    }
}
