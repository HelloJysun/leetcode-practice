package com.jysun.practice.medium;

import java.util.*;

/**
 * @author Jysun
 * @description  电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @date 2020/8/26 22:35
 */
public class Medium17 {

    public static void main(String[] args) {
        Medium17 obj = new Medium17();
        System.out.println(obj.letterCombinations("23"));
        System.out.println(obj.letterCombinations2("23"));
    }

    Map<Character, List<Character>> dic = new HashMap<Character, List<Character>>() {{
        put('2', Arrays.asList('a', 'b', 'c'));
        put('3', Arrays.asList('d', 'e', 'f'));
        put('4', Arrays.asList('g', 'h', 'i'));
        put('5', Arrays.asList('j', 'k', 'l'));
        put('6', Arrays.asList('m', 'n', 'o'));
        put('7', Arrays.asList('p', 'q', 'r', 's'));
        put('8', Arrays.asList('t', 'u', 'v'));
        put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(res, digits, 0, new StringBuilder());
        return res;
    }

    /**
     * 假如输入 23 ，那就是 abc -> def 每一层都需要拼接
     * dfs：null -> a -> d -> a -> e -> a -> f -> null -> b -> d -> b ...
     *                null
     *           /    |     \
     *         a      b       c
     *      / | \   / | \   / | \
     *     d  e f d  e  f  d  e  f
     */
    private void dfs(List<String> res, String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
        } else {
            List<Character> letters = dic.get(digits.charAt(i));
            for (Character letter : letters) {
                sb.append(letter);
                dfs(res, digits, i + 1, sb);
                sb.deleteCharAt(i);
            }
        }
    }

    /**
     * bfs。按照层来遍历
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                List<Character> letters = dic.get(digits.charAt(i));
                for (Character letter : letters) {
                    queue.offer(str + letter);
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }

}
