package com.jysun.practice.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 周赛293
 *
 * @author json
 * @since 2022/5/15
 */
public class Week293 {

    public static void main(String[] args) {
        Week293 week293 = new Week293();

        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(week293.removeAnagrams(words));

        int[] special = {7,6,8};
        System.out.println(week293.maxConsecutive(6,8,special));

        int[] candidates = {84,40,66,44,91,90,1,14,73,51,47,35,18,46,18,65,55,18,16,45,43,58,90,92,91,43,44,76,85,72,24,89,60,94,81,90,86,79,84,41,41,28,44};
        System.out.println(week293.largestCombination(candidates));
    }

    /**
     * 5234. 移除字母异位词后的结果数组
     * 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
     *
     * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
     *
     * 0 < i < words.length
     * words[i - 1] 和 words[i] 是 字母异位词 。
     * 只要可以选出满足条件的下标，就一直执行这个操作。
     *
     * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
     *
     *
     *
     * 示例 1：
     *
     * 输入：words = ["abba","baba","bbaa","cd","cd"]
     * 输出：["abba","cd"]
     * 解释：
     * 获取结果数组的方法之一是执行下述步骤：
     * - 由于 words[2] = "bbaa" 和 words[1] = "baba" 是字母异位词，选择下标 2 并删除 words[2] 。
     *   现在 words = ["abba","baba","cd","cd"] 。
     * - 由于 words[1] = "baba" 和 words[0] = "abba" 是字母异位词，选择下标 1 并删除 words[1] 。
     *   现在 words = ["abba","cd","cd"] 。
     * - 由于 words[2] = "cd" 和 words[1] = "cd" 是字母异位词，选择下标 2 并删除 words[2] 。
     *   现在 words = ["abba","cd"] 。
     * 无法再执行任何操作，所以 ["abba","cd"] 是最终答案。
     * 示例 2：
     *
     * 输入：words = ["a","b","c","d","e"]
     * 输出：["a","b","c","d","e"]
     * 解释：
     * words 中不存在互为字母异位词的两个相邻字符串，所以无需执行任何操作。
     *
     *
     * 提示：
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 10
     * words[i] 由小写英文字母组成
     */
    /**
     * 如果连续三个相同的异位词，则保留的肯定是最左侧那个单词
     * 所以从1开始遍历，记录前一个单词的字母出现次数，如果相同就移除当前位，如果不同就计算当前单词字母出现次数表直到最后
     */
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        // 初始化字母出现次数表
        int[] dic1 = new int[26];
        char[] chars1 = words[0].toCharArray();
        for (char c : chars1) {
            dic1[c - 'a']++;
        }
        res.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char[] chars2 = words[i].toCharArray();
            int[] dic2 = new int[26];
            for (char c : chars2) {
                dic2[c - 'a']++;
            }
            // 判断dic1和dic2是否相同
            boolean flag = true;
            for (int j = 0; j < dic1.length; j++) {
                if (dic1[j] != dic2[j]) {
                    flag = false;
                    break;
                }
            }
            // 不是异位词就重置dic1为当前数组，并将当前单词放进结果集
            if (!flag) {
                res.add(words[i]);
                dic1 = dic2;
            }
        }
        return res;
    }

    /**
     * 6064. 不含特殊楼层的最大连续楼层数 显示英文描述
     * 通过的用户数2434
     * 尝试过的用户数2757
     * 用户总通过次数2439
     * 用户总提交次数3592
     * 题目难度Medium
     * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
     *
     * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
     *
     * 返回不含特殊楼层的 最大 连续楼层数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：bottom = 2, top = 9, special = [4,6]
     * 输出：3
     * 解释：下面列出的是不含特殊楼层的连续楼层范围：
     * - (2, 3) ，楼层数为 2 。
     * - (5, 5) ，楼层数为 1 。
     * - (7, 9) ，楼层数为 3 。
     * 因此，返回最大连续楼层数 3 。
     * 示例 2：
     *
     * 输入：bottom = 6, top = 8, special = [7,6,8]
     * 输出：0
     * 解释：每层楼都被规划为特殊楼层，所以返回 0 。
     *
     *
     * 提示
     *
     * 1 <= special.length <= 105
     * 1 <= bottom <= special[i] <= top <= 109
     * special 中的所有值 互不相同
     */
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int right = bottom;
        int i = 0;
        int max = 0;
        while (right <= top) {
            if (i < special.length && special[i] >= right) {
                right = special[i] - 1;
                max = Math.max(max, right - bottom + 1);
                bottom = special[i++] + 1;
                right = bottom;
            } else {
                // 没元素了直接取top
                max = Math.max(max, top - bottom + 1);
                bottom = top + 1;
                right = top + 1;
            }
        }
        return max;
    }

    /**
     * 6065. 按位与结果大于零的最长组合 显示英文描述
     * 通过的用户数1834
     * 尝试过的用户数2257
     * 用户总通过次数1851
     * 用户总提交次数2816
     * 题目难度Medium
     * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
     *
     * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
     * 同样，对 nums = [7] 而言，按位与等于 7 。
     * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
     *
     * 返回按位与结果大于 0 的 最长 组合的长度。
     *
     *
     *
     * 示例 1：
     *
     * 输入：candidates = [16,17,71,62,12,24,14]
     * 输出：4
     * 解释：组合 [16,17,62,24] 的按位与结果是 16 & 17 & 62 & 24 = 16 > 0 。
     * 组合长度是 4 。
     * 可以证明不存在按位与结果大于 0 且长度大于 4 的组合。
     * 注意，符合长度最大的组合可能不止一种。
     * 例如，组合 [62,12,24,14] 的按位与结果是 62 & 12 & 24 & 14 = 8 > 0 。
     * 示例 2：
     *
     * 输入：candidates = [8,8]
     * 输出：2
     * 解释：最长组合是 [8,8] ，按位与结果 8 & 8 = 8 > 0 。
     * 组合长度是 2 ，所以返回 2 。
     *
     *
     * 提示：
     *
     * 1 <= candidates.length <= 105
     * 1 <= candidates[i] <= 107
     */
    LinkedList<Integer> track = new LinkedList<>();
    int max = 0;
    public int largestCombination(int[] candidates) {
        backtrack(candidates, 0, Integer.MAX_VALUE);
        return max;
    }

    public void backtrack(int[] candidates, int start, int xor) {
        if (!track.isEmpty() && xor > 0) {
            max = Math.max(max, track.size());
        }
        for (int i = start; i < candidates.length; i++) {
            if (xor == 0) {
                break;
            }
            track.addLast(candidates[i]);
            backtrack(candidates, i + 1, xor & candidates[i]);
            track.removeLast();
        }
    }
}
