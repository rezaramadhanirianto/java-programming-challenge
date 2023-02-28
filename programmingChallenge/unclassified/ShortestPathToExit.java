package programmingChallenge.unclassified;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/1128831/tiktok-round-1
// similar https://leetcode.com/problems/walls-and-gates/
public class ShortestPathToExit {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        shortestPathToExit(grid);
        for(int[] g: grid){
            System.out.println(Arrays.toString(g));
        }
    }

    public static void shortestPathToExit(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) dfs(grid, i, j, -1, new HashSet<>());
            }
        }
    }

    static void dfs(int[][] grid, int i, int j, int prev, Set<String> set){
        if(i >= grid.length || j >= grid.length || i < 0 || j < 0 || grid[i][j] == -1) return;
        else if(!set.add(i + " " + j)) return;

        prev++;
        if(grid[i][j] != 0) grid[i][j] = Math.min(prev, grid[i][j]);
        dfs(grid, i - 1, j, prev, set);
        dfs(grid, i + 1, j, prev, set);
        dfs(grid, i , j - 1, prev, set);
        dfs(grid, i , j + 1, prev, set);
    }
}
