package programmingChallenge.hard.dp;

// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
public class MaximumSumOf3NonOverlappingSubArrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n];
        int[][] dp = new int[4][n], ids = new int[4][n];
        sums[0] = nums[0];
        for(int i = 1; i < n; i++){
            sums[i] += nums[i] + sums[i-1];
            if(i >= k) sums[i] -= nums[i-k];
        }

        for(int i = 1; i < 4; i++){
            dp[i][0] = nums[0];
            for(int j = 1; j < n; j++){
                dp[i][j] = sums[j];
                ids[i][j] = j + 1 - k;
                if(j >= k) dp[i][j] += dp[i-1][j-k];
                if(dp[i][j-1] >= dp[i][j]){
                    dp[i][j] = dp[i][j-1];
                    ids[i][j] = ids[i][j-1];
                }

            }
        }
        int[] res = new int[3];
        res[2] = ids[3][n-1];
        res[1] = ids[2][res[2] - 1];
        res[0] = ids[1][res[1] - 1];
        return res;
    }
}
