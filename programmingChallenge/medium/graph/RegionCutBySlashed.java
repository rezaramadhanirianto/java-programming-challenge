package programmingChallenge.medium.graph;

// https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
// this solution similar to https://leetcode.com/problems/number-of-islands/description/
// main difference of them is in this problem we should upscale grid to m * 3, why not n * 2?
// (wrong)  -->  (should be this)
// 1010            110110
// 0101            101101
// 1011            011011
// 0111            110111
//                 101111
//                 011111
// if we only upscale to n * 2
// it would be 5 islands cuz DFS only check horizontal - vertical (i+1,i-1,j+1,j-1)
// 1 0 2 0
// 0 3 0 5
// 4 0 5 5
// 0 5 5 5
public class RegionCutBySlashed {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int res = 0;
        // upscale grid
        int[][] map = new int[3*n][3*n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int col = 3 * j;
                int row = 3 * i;
                // add divider
                // ex:
                //     D
                //   D
                // D
                // or
                // D
                //   D
                //     D
                if(grid[i].charAt(j) == '/') map[row][col+2] = map[row+1][col+1] = map[row+2][col] = 1;
                if(grid[i].charAt(j) == '\\') map[row][col] = map[row+1][col+1] = map[row+2][col+2] = 1;
            }
        }

        for(int i = 0; i < n*3; i++){
            for(int j = 0; j < n *3; j++){
                if(map[i][j] == 0){
                    dfs(map, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    void dfs(int[][] map, int i, int j){
        if(i < 0 || i >= map.length || j < 0 || j >= map[i].length || map[i][j] == 1) return;

        map[i][j] = 1;
        dfs(map, i+1, j);
        dfs(map, i-1, j);
        dfs(map, i, j+1);
        dfs(map, i, j-1);
    }
}
