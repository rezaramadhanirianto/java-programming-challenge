package programmingChallenge.hard.dp;

// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/description/
// O(M*N*K(M+N))
public class NumberOfWaysCuttingPizza {
    int MOD = (int) 1e9 + 7;
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][] sum = new int[m+1][n+1];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                sum[i][j] += sum[i+1][j] + sum[i][j+1] - sum[i+1][j+1];
                sum[i][j] += (pizza[i].charAt(j) == 'A') ? 1 : 0;
            }
        }

        return helper(sum, new Integer[k+1][m+1][n+1], 0, 0, k-1, n, m);
    }

    int helper(int[][] sum, Integer[][][] dp, int r, int c, int k, int n, int m){
        if(sum[r][c] == 0) return 0;
        if(k == 0) return 1;
        if(dp[k][r][c] != null) return dp[k][r][c];

        int res = 0;
        for(int i = r+1; i < m; i++){
            if(sum[r][c] - sum[i][c] > 0){ // cut if the upper piece contains at least one apple
                res += (helper(sum, dp, i, c, k-1, n, m) % MOD);
                res %= MOD;
            }
        }

        for(int i = c+1; i < n; i++){
            if(sum[r][c] - sum[r][i] > 0) { // cut if the left piece contains at least one apple
                res += (helper(sum, dp, r, i, k-1, n, m) % MOD);
                res %= MOD;
            }
        }

        return dp[k][r][c] = res;
    }
}
