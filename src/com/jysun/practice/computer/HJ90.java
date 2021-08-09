package com.jysun.practice.computer;

import java.util.Scanner;

/**
 * @author Jysun
 * @description HJ90
 * 题目描述
 * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 * 输入描述:
 * 输入一个ip地址
 *
 * 输出描述:
 * 返回判断的结果YES or NO
 *
 * 示例1
 * 输入
 * 10.138.15.1
 *
 * 输出
 * YES
 * @date 2020/6/20 10:03
 */
public class HJ90 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();

        String[] ipArr = ip.split("\\.");
        boolean flag = true;
        for (String s : ipArr) {
            Integer num = Integer.valueOf(s);
            if (num < 0 || num > 255) {
                flag = false;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }


}
