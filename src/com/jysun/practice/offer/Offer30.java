package com.jysun.practice.offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * @author jysun
 * @since 2021/8/10
 */
public class Offer30 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    static class MinStack {

        Stack<Integer> min;
        Stack<Integer> data;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min = new Stack<>();
            data = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            min.push(min.isEmpty() ? x : Math.min(min.peek(), x));
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
