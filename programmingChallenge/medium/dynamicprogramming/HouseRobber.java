package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/house-robber
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2; i < n; i++){
            int prev = dp[i-2];
            int prevPrev = (i < 3) ? 0 : dp[i-3];
            dp[i] = Math.max(nums[i], Math.max(prev + nums[i], prevPrev + nums[i]));
        }
        return Math.max(dp[n-1], dp[n-2]);
    }

    public int rob2(int[] nums) {
        int n = nums.length, rob = 0, notrob = 0;
        // 10 1 1 10
        // notrob -> 0 rob -> 10
        // notrob -> 0 + 10 rob -> 0 + 1
        // notrob -> 10 (Math.max(10, 1)) rob -> 10 + 1
        // notrob -> 11 rob -> 20 (10 + 10)

        for(int i = 0; i < n; i++){
            int curr = notrob + nums[i];
            notrob = Math.max(notrob, rob);
            System.out.println(notrob + " " + curr);
            rob = curr;
        }
        return Math.max(notrob, rob);
    }
}
