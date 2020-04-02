package com.jysun.practice.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jysun
 * @description Simple771宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * @date 2020/4/1 21:48
 */
public class Simple771 {

    public static void main(String[] args) {
        Simple771 obj = new Simple771();
        System.out.println(obj.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(obj.numJewelsInStonesOpt("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        int cnt = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int numJewelsInStonesOpt(String J, String S) {
        int[] map = new int[123];
        for (char s : S.toCharArray()) {
            map[s] += 1;
        }
        int cnt = 0;
        for (char j : J.toCharArray()) {
            cnt += map[j];
        }
        return cnt;
    }
}
