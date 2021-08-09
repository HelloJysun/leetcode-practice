package com.jysun.practice.computer;

import java.util.Scanner;

/**
 * @author Jysun
 * @description HJ106
 * @date 2020/6/14 9:19
 */
public class HJ106 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder res = new StringBuilder(input);
        System.out.println(res.reverse());
    }


}
