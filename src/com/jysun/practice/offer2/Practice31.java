package com.jysun.practice.offer2;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author json
 * @since 2022/2/27
 */
public class Practice31 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(new Practice31().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            // 模拟入栈后，栈顶元素不等于popped出栈元素就继续入栈，等于就要弹出栈顶元素，移动popped出栈下标
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
