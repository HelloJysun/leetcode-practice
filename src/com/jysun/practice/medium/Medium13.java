package com.jysun.practice.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author json
 * @see Medium12
 * @since 2021/5/15
 */
public class Medium13 {

    public static void main(String[] args) {
        Medium13 obj = new Medium13();
        System.out.println(obj.romanToIntOpt("III"));
        System.out.println(obj.romanToIntOpt("IV"));
        System.out.println(obj.romanToIntOpt("IX"));
        System.out.println(obj.romanToIntOpt("LVIII"));
        System.out.println(obj.romanToIntOpt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        String[] rome = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        int res = 0;
        for (int i = rome.length - 1; i >= 0; i--) {
            while (s.indexOf(rome[i]) == 0) {
                res += nums[i];
                s = s.substring(rome[i].length());
            }
        }
        return res;
    }

    /**
     * 不同于整数转罗马数字做法，不需要组合每个罗马数字代表的数值
     * 通过当前罗马数字代表的数值和右边比较。因为通常情况下，罗马数字中小的数字在大的数字的右边
     * 存在的特例情况 IV 代表的4，此时需要右侧数值 - 左侧数值，即>右直接+，<右直接-
     * MCMXCIV
     * = M - C + M - X + C - I + V
     * = 1000 + (- 100 + 1000) + (- 10 + 100) + (- 1 + 5)
     * = M   +       CM        +       XC     +   IV
     */
    public int romanToIntOpt(String s) {
        Map<Character, Integer> rome = new LinkedHashMap<Character, Integer>() {{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};
        int res = 0;
        for (int i = 0, len = s.length(); i < len - 1; i++) {
            if (rome.get(s.charAt(i)) >= rome.get(s.charAt(i + 1))) {
                res += rome.get(s.charAt(i));
            } else {
                res -= rome.get(s.charAt(i));
            }
        }
        res += rome.get(s.charAt(s.length() - 1));
        return res;
    }
}
