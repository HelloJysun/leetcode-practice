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
        int[] pushed = {0,1};
        int[] popped = {1,0};
        System.out.println(new Practice31().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            // 模拟入栈
            stack.push(pushed[i++]);
            // 一旦弹出序列同栈顶相等就模拟出栈
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        // 模拟完入栈出栈，辅助栈内为空
        return stack.isEmpty();
    }
}
