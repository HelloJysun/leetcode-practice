package com.jysun.practice.computer;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Jysun
 * @description HJ95
 * @date 2020/6/13 7:51
 */
public class HJ95 {

    static String[] bidNums = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    // 万亿，仟亿，佰亿，拾亿，亿，仟万，佰万，拾万，万，仟，佰，拾，元，角，分
    static String[] units = {"万", "仟", "佰", "拾", "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分"};

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            double rmbNum = sc.nextDouble();

            long round = Math.round(rmbNum * 100);
            if (round == 0) {
                System.out.println("零元整");
            }
            String strValue = round + "";
            int j = units.length - strValue.length();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < strValue.length(); i++, j++) {
                char ch = strValue.charAt(i);
                if (ch == '0') {
                    if (units[j] == "亿" || units[j] == "万" || units[j] == "元") {
                        res.append(units[j]);
                    }
                } else {
//                    if (res.length() == 0 && ch - '0' == 1 && j < 12) {
//                        res.append(units[j]);
//                        continue;
//                    }
                    res.append(bidNums[ch - '0']).append(units[j]);
                }
            }

            System.out.println("人民币" + res.toString());
        }
    }

    private static void test2() {
        String[] nums = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] units = {"仟", "佰", "拾", "兆", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分"};
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            double money = sc.nextDouble();
            // money 小数点后边两位 倍增100取每位数字
            String s = String.valueOf(Math.round(money * 100));
            StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            int unitIdx = units.length - chars.length;
            for (int i = 0; i < chars.length; i++, unitIdx++) {
                char ch = chars[i];
                // 0不带单位，只在关键元万亿上加单位，其他0抛弃
                if (ch == '0') {
                    if ((Objects.equals(units[unitIdx], "兆") ||
                            Objects.equals(units[unitIdx], "亿") ||
                            Objects.equals(units[unitIdx], "万") ||
                            Objects.equals(units[unitIdx], "元")))
                        res.append(units[unitIdx]);
                } else {
                    res.append(nums[ch - '0'])// 数字
                            .append(units[unitIdx]);// 单位
                }
            }
            System.out.println(res.toString());
        }
    }
}
