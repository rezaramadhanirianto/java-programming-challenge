package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/decode-ways/
// O(N)
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) return 0;

        int n = s.length();
        int[] dp = new int[n];
        char[] chars = s.toCharArray();

        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int curr = chars[i] - '0';
            int prev = (chars[i-1] - '0') * 10 + curr;
            if(curr != 0){
                dp[i] += dp[i-1];
            }

            // if curr and previous can be 2 character
            // means there are dp[i-2] more new decode ways.
            // it same concept with https://leetcode.com/problems/climbing-stairs/description/
            // that means we have two choices first use current letter and if i-1 + "" + i >= 10 && <= 26
            // 1 - 9 and 10 - 26 that's why we sum with 1-2
            if(prev >= 10 && prev <= 26){
                dp[i] += (i >= 2) ? dp[i-2] : 1;
            }
        }
        return dp[n-1];
    }

}
