package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/partition-array-for-maximum-sum/description/
/**
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 *
 * If we take
 * [15,15,15,15,10,10,10]
 * this invalid because 15 more than k
 * **/
public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int res = 0, n = arr.length;
        // to handle too much logic like i - (j - 1)
        int[] dp = new int[n+1];
        // to handle too much logic like i - (j - 1)
        for(int i = 1; i <= n; i++){
            int numMax = 0, max = 0;
            for(int j = 1; j <= k && i - j >= 0; j++){
                numMax = Math.max(numMax, arr[i-j]);
                max = Math.max(max, dp[i-j] + numMax * j);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
