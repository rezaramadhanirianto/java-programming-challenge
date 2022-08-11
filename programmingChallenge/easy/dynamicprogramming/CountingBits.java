package programmingChallenge.easy.dynamicprogramming;

// https://leetcode.com/problems/counting-bits
class CountingBits {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 0; i <= n; i++){
            arr[i] = solve(i, arr);
        }
        return arr;
    }

    public int solve(int i, int[] memo){
        if(i == 0) return 0;
        if(i == 1) return 1;

        if(memo[i] != 0) return memo[i];


        if(i % 2 == 0) {
            memo[i] = solve(i/2, memo);
            return memo[i];
        }else{
            memo[i] = solve(i/2, memo) + 1;
            return memo[i];
        }
    }
}