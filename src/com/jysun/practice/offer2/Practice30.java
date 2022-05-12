package com.jysun.practice.offer2;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author json
 * @since 2022/5/12
 */
public class Practice30 {

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

        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            data.push(x);
            if (!min.isEmpty()) {
                min.push(Math.min(min.peek(), x));
            } else {
                min.push(x);
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                min.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
