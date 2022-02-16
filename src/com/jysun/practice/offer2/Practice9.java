package com.jysun.practice.offer2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author json
 * @since 2022/2/16
 */
public class Practice9 {

    public static void main(String[] args) {
        CStack stack = new CStack();
        stack.appendTail(1);
        stack.appendTail(2);
        System.out.println(stack.deleteHead());
        stack.appendTail(3);
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
    }

    static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            // 栈2有值直接返回
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            // 栈2没值看栈1，将1挪到2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            // 弹出栈2
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return -1;
        }
    }

    static class CStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public CStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            queue1.add(value);
        }

        public int deleteHead() {
            // 队2有值直接返回
            if (!queue2.isEmpty()) {
                return queue2.poll();
            }
            // 队2没值看队1，将队1挪到队2
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            // 弹出队2
            if (!queue2.isEmpty()) {
                return queue2.poll();
            }
            return -1;
        }
    }
}
