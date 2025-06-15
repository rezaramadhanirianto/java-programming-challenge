package programmingChallenge.hard.dp;

// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/
class NumberOfIncreasingPathInAGrid {
    // N * M
    // Time complexity: The time complexity of the countPaths method is O(n * m), where n and m are the dimensions of the grid. This is because it iterates through each cell in the grid exactly once. The solve method has recursive calls, but each cell's result is memoized, ensuring that each cell is calculated only once.
    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Integer[][] dp = new Integer[n][m];
        long res = n * m;

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                res += helper(dp, grid, i, j);
                res %= 1e9 + 7;
            }
        }
        return (int) res;
    }

    int helper(Integer[][] dp, int[][] grid, int i, int j){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return 0;
        else if(dp[i][j] != null) return dp[i][j];

        int[][] moves = new int[][]{{0,1}, {1,0}, {-1, 0}, {0, -1}};

        int paths = 0;
        for(int[] move: moves){
            if( i+move[0] >= grid.length ||
                    i+move[0] < 0 ||
                    j + move[1] < 0 ||
                    j + move[1] >=  grid[0].length) continue;

            if(grid[i+move[0]][j+move[1]] <= grid[i][j]) continue;

            paths += helper(dp, grid, i + move[0], j + move[1]) + 1;
        }

        paths %= (int) 1e9 + 7;
        return dp[i][j] = paths;
    }
}