package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-353/problems/maximum-number-of-jumps-to-reach-the-last-index/
public class MaximumNumberOfJumpToReachLastIndex {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(dp[j] >= 0 && Math.abs(nums[j] - nums[i]) <= target){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }
}
