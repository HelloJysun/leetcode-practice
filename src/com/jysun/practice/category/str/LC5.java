package com.jysun.practice.category.str;

/**
 * 最长回文子串
 *
 * @author jysun
 * @since 2022/4/2
 */
public class LC5 {
    public static void main(String[] args) {
        System.out.println(new LC5().longestPalindromeDP("cbbd"));
    }

    /**
     * 双重for循环，枚举所有连续字符串可能，然后左右向中心闭合
     */
    public String longestPalindrome(String s) {
        int maxL = 0, maxR = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && (j - i) > (maxR - maxL)) {
                    maxL = i;
                    maxR = j;
                }
            }
        }
        return s.substring(maxL, maxR + 1);
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left > right;
    }

    public String longestPalindromeOpt(String s) {
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome(s, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public void isPalindrome(String s, int left, int[] range) {
        int right = left;
        while (right < s.length() - 1 && s.charAt(left) == s.charAt(right + 1)) {
            right++;
        }
        while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        if (right - left > range[1] - range[0]) {
            range[0] = left;
            range[1] = right;
        }
    }

    public String longestPalindromeDP(String s) {
        // dp[i][j]表示从i到j是否为回文，转移方程dp[i][j] = dp[i+1][j-1] && s(i)==s(j)
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 单个字符对角线均为回文
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxL = 0, maxR = 0;
        // 既然是从i到j，那必然i<=j，所以dp数组的左下方为i>j可以忽略不用处理
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                // 这里考虑bb情况，dp[i][j]取dp[i+1][j-1]转移状态时其实就是本身，但只需要判断s(i)==s(j)即可
                // 考虑bab情况，同样如此合并为单个字符，只需要判断s(i)==s(j)
                dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i <= 2);
                if (dp[i][j] && j - i > maxR - maxL) {
                    maxL = i;
                    maxR = j;
                }
            }
        }
        return s.substring(maxL, maxR + 1);
    }
}
