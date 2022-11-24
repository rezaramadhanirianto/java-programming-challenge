package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/jump-game/
public class JumpGame {
    // greedy
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    // dp
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for(int i = 0; i < n-1; i++){
            int jump = nums[i] + i;
            jump = (jump > n-1) ? n-1 : jump;
            for(int j = jump; j >= i; j--){
                if(dp[j]) break;
                if(dp[i]) dp[j] = true;
                else break;
            }
        }

        return dp[n-1];
    }
}
