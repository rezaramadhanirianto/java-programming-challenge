package programmingChallenge.medium.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// intuition: we have to found all possible path and find the minimum, that means we have to use BFS
// because we use DFS that's no possible to find from the root, 2 root and so on.
public class FindShortestPathInBinaryTree {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1, 1},{1,-1}};
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                for(int[] dir: dirs){
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    if(nextRow == row && nextCol == col) return step;
                    if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col || visited[nextRow][nextCol] || grid[nextRow][nextCol] == 1) continue;
                    if(nextRow == row && nextRow == col) return step;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
        return -1;
    }
}
