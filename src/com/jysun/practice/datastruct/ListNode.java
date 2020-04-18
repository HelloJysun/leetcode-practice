package com.jysun.practice.datastruct;

/**
 * @author Jysun
 * @description ListNode
 * @date 2020/4/15 21:45
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
