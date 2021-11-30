package com.jysun.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 提示：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * @author jysun
 * @since 2021/11/23
 */
public class Medium784 {

    public static void main(String[] args) {
        Medium784 obj = new Medium784();
        System.out.println(obj.letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, 0);
        return res;
    }

    private void dfs(String s, List<String> res, int i) {
        if (i == s.length()) {
            res.add(s);
            return;
        }
        if (Character.isLetter(s.charAt(i))) {
            // 当前为字母时，大小写均递归一遍
            s = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
            dfs(s, res, i + 1);
            s = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
        }
        dfs(s, res, i + 1);
    }
}
