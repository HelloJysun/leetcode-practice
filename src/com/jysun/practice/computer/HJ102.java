package com.jysun.practice.computer;

import java.util.*;

/**
 * @author Jysun
 * @description HJ102
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 *
 * 实现以下接口：
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出
 * 清空目前的统计结果，重新统计
 * 调用者会保证：
 * 输入的字符串以‘\0’结尾。
 *
 * 输入描述:
 * 输入一串字符。
 *
 * 输出描述:
 * 对字符中的
 * 各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 *
 * 示例1
 * 输入
 * aadddccddc
 * 输出
 * dca
 *
 * @date 2020/6/15 21:20
 */
public class HJ102 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> sort = new ArrayList<>(map.entrySet());

            StringBuilder res = new StringBuilder();
            Collections.sort(sort, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    if (o1.getValue().intValue() == o2.getValue().intValue()) {
                        return o1.getKey() - o2.getKey();
                    }
                    return o2.getValue() - o1.getValue();
                }
            });
            for (Map.Entry<Character, Integer> entry : sort) {
                res.append(entry.getKey());
            }
            System.out.println(res.toString());
        }
    }
}
