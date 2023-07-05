package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/ways-to-split-array-into-good-subarrays/description/
public class WaysToSplitArrayIntoGoodSubArrays {
    int mod = (int) 1e9 + 7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int i = 0;
        long res = 1;
        for(; i < n; i++) if(nums[i] == 1) break;
        if(i == n) return 0;

        int j = i++;
        for(; i < n; i++){
            if(nums[i] == 1){
                res *= i - j;
                res %= mod;
                j = i;
            }
        }

        return (int)res;
    }

    // TLE
    // Need to handle edge cases when so many 0's and little bit 1's among them
    public int numberOfGoodSubarraySplits2(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n+1];
        int res = helper(nums, 0, dp);
        return res;
    }

    int helper(int[] nums, int i, Integer[] dp){
        int res = 0, curr = 0;
        int idx = i;
        if(dp[i] != null) return dp[i];
        while(curr <= 1 && i < nums.length){
            curr += nums[i++];
            if(curr == 1) {
                res = (res + helper(nums, i, dp)) % mod;
            }
        }
        if(curr <= 1) return dp[idx] = curr;
        return dp[idx] = res;
    }
}
