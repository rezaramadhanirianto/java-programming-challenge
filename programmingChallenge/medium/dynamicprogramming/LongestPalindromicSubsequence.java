package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(s.toCharArray(), 0, s.length()-1, dp);
    }

    int helper(char[] chars, int i, int j, int[][] memo){
        if(i >= chars.length || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        memo[i][j] = (chars[i] == chars[j]) ? helper(chars, i+1, j-1, memo) + 1
                : Math.max(helper(chars, i+1, j, memo), helper(chars, i, j-1, memo));
        return memo[i][j];
    }
}
