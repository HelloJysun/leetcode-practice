package com.jysun.practice.offer2;

import java.util.*;

/**
 * 字符串的排列
 *
 * @author jysun
 * @since 2022/3/1
 */
public class Practice38 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Practice38().permutation("abc")));
    }

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        char[] data = new char[s.length()];
        boolean[] visited = new boolean[s.length()];
        dfs(s, data, 0, visited, set);
        return set.toArray(new String[0]);
    }

    public void dfs(String s, char[] data, int index, boolean[] visited, Set<String> set) {
        if (index == s.length()) {
            set.add(new String(data));
            return;
        }
        // 从每个位置出发将元素标记访问
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            data[index++] = s.charAt(i);
            dfs(s, data, index, visited, set);
            // 回溯重置访问标记
            visited[i] = false;
            index--;
        }
    }
}
