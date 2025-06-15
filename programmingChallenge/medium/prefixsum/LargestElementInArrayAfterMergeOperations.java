package programmingChallenge.medium.prefixsum;

// https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/description/
public class LargestElementInArrayAfterMergeOperations {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            dp[i] = nums[i];
            if(dp[i+1] >= nums[i]) dp[i] += dp[i+1];
        }
        long max = 0;
        for(long num: dp){
            max = Math.max(num, max);
        }
        return max;
    }
}
