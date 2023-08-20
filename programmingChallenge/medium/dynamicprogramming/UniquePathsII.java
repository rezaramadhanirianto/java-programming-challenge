package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    int[][] dirs = new int[][]{{0,1},{1,0}};
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return helper(obstacleGrid, 0, 0);
    }

    int helper(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1) return 1;
        if(dp[i][j] != null) return dp[i][j];

        int res = 0;
        for(int[] dir: dirs){
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            res += helper(grid, nextX, nextY);
        }
        return dp[i][j] = res;
    }
}
