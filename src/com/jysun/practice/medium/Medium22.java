package com.jysun.practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jysun
 * @description Medium22 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 * @date 2020/4/9 9:21
 */
public class Medium22 {

    public static void main(String[] args) {
        Medium22 obj = new Medium22();
        List<String> res = obj.generateParenthesis(3);
        System.out.println(res);
    }

    /**
     * 回溯 + 剪枝
     * 穷举所有选择可能性，并剔除不合法情况
     * n 个括号对对应 n(l) 个左括号和 n(r) 个右括号
     * 如果一开始使用右括号则 l > r 会造成后续有一个左括号无法匹配，所以这种情况需要剔除
     * 如果一开始使用左括号则剩 l-1 个左括号，r 个右括号，逐渐向下分情况讨论左括号和右括号选择问题
     * 可以发现 l > 0,r > 0 才可以使用，一旦 l > r 就可以舍弃即剪枝操作
     * 递归的终止条件就是 l == 0 && r == 0 说明此时括号已用完即生成了一个合法的括号对
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
//        dfs1(n, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int l, int r, String s, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if (l > r) {
            return;
        }
        if (l > 0) {
            dfs(l - 1, r, s + "(", res);
        }
        if (r > 0) {
            dfs(l, r - 1, s + ")", res);
        }
    }

    private void dfs1(int l, int r, StringBuilder s, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(s.toString());
            return;
        }
        if (l > 0) {
            dfs1(l - 1, r, s.append("("), res);
            s.deleteCharAt(s.length() - 1);
        }
        if (r > l) {
            dfs1(l, r - 1, s.append(")"), res);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
