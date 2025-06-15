package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/
public class MaxNonDecreasingSubArrayFromTwoArrays {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if(n == 1) return 1;

        int[][] dp = new int[2][n];
        for(int[] d: dp) Arrays.fill(d, 1);
        int res = 1;
        for(int i = 1; i < n; i++){
            if(nums1[i] >= nums1[i-1]) dp[0][i] = Math.max(dp[0][i], dp[0][i-1] + 1);
            if(nums1[i] >= nums2[i-1]) dp[0][i] = Math.max(dp[0][i], dp[1][i-1] + 1);

            if(nums2[i] >= nums1[i-1]) dp[1][i] = Math.max(dp[1][i], dp[0][i-1] + 1);
            if(nums2[i] >= nums2[i-1]) dp[1][i] = Math.max(dp[1][i], dp[1][i-1] + 1);

            res = Math.max(dp[0][i], Math.max(dp[1][i], res));
        }
        return res;
    }
}
