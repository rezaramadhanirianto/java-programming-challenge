package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public int jump(int[] nums) {
        int end = 0, max = 0, jump = 0;

        for(int i = 0; i < nums.length-1; i++){
            max = Math.max(max, i + nums[i]);
            if(i == end){
                jump++;
                end = max;
            }
        }
        return jump;
    }

    // dp O(N^2)
    public int jump2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int[] dp = new int[n];
        for(int i = 1; i < nums.length; i++) dp[i] = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++){
            int jump = nums[i] + i;
            jump = (jump > n-1) ? n-1 : jump;
            for(int j = jump; j > i; j--){
                if(i == 0 || dp[i] > 0) dp[j] = Math.min(dp[i]+1, dp[j]);
                else break;
            }
        }

        return dp[n-1];
    }
}
