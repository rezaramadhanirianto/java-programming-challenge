package programmingChallenge.medium.graph;

// https://leetcode.com/problems/number-of-closed-islands/
// basic idea is change all neighbor closed island to 1, if last closed island follow requirement count++
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0 && dfs(grid, i, j)) count++;
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1) return false;
        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;
        boolean top = dfs(grid,i+1,j);
        boolean bottom = dfs(grid,i-1,j);
        boolean right = dfs(grid,i,j+1);
        boolean left = dfs(grid,i,j-1);
        return top && bottom && right && left;

        // we can't do this cuz, when top return false that means bottom, left right will not executed
        // and in that case we can't change grid[i][j] = 1 in neighbor of node
        // ex:
        // 1, 1, 1, 1, 1
        // 1, 1, 0, 1, 1
        // 0, 0, 0, 0, 1
        // 1, 1, 1, 1, 1
        // it should be zero islands because closed island should surround with opened island
        // if we run code down below it will be
        // 1, 1, 1, 1, 1
        // 1, 1, 1, 1, 1
        // 1, 1, 1, 0, 1
        // 1, 1, 1, 1, 1
        // because the that will be 1 islands
        // return dfs(grid,i+1,j) && dfs(grid,i-1,j) && dfs(grid,i,j+1) && dfs(grid,i,j-1);
    }
}
