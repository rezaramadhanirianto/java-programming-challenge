package programmingChallenge.hard.unionfind;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/last-day-where-you-can-still-cross/description/
public class LastDayYouCanStillCross {
    // union find
    public int latestDayToCross(int row, int col, int[][] cells) {
        //index row * col: top, index bottom: row * col + 1
        int[] parent = new int[row*col+2];
        int topIndex = row * col;
        int bottomIndex = row * col + 1;
        for(int i = 0; i < parent.length; i++) parent[i] = i;

        boolean[][] blockers = new boolean[row][col];
        for(int[] cell: cells) blockers[cell[0] - 1][cell[1] - 1] = true;

        for(int i = cells.length-1; i >= 0; i--){
            int[] cell = cells[i];
            int r = cell[0] - 1;
            int c = cell[1] - 1;
            blockers[r][c] = false;
            int currentIndex = (r * col) + c;
            System.out.println(currentIndex);
            if(r - 1 >= 0 && !blockers[r-1][c]){
                union(parent, currentIndex - col, currentIndex);
            } else if (r == 0) {
                union(parent, topIndex, currentIndex);
            }
            if(r + 1 < row && !blockers[r + 1][c]) {
                union(parent, currentIndex + col, currentIndex);
            } else if(r + 1 == row) {
                union(parent, bottomIndex, currentIndex);
            }

            if(c - 1 >= 0 && !blockers[r][c - 1]) {
                union(parent, currentIndex - 1, currentIndex);
            }
            if(c + 1 < col && !blockers[r][c + 1]) {
                union(parent, currentIndex + 1, currentIndex);
            }
            if(find(parent, topIndex) == find(parent, bottomIndex)) return i;
        }
        return 0;
    }

    void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = parent[find(parent, b)];
    }

    int find(int[] parent, int a) {
        if(a != parent[a]){
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];
    }

    // Solution 2
    // BFS + Binary Searcg
    public int latestDayToCross2(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(helper(row, col, cells, mid)){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }

    int[][] DIR = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean helper(int row, int col, int[][] cells, int day){
        int[][] matrix = new int[row][col];
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < day; i++) matrix[cells[i][0]-1][cells[i][1]-1] = 1;
        for(int i = 0; i < col; i++){
            if(matrix[0][i] != 1) queue.offer(new int[]{0, i});
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[1] < 0 || curr[1] >= col || curr[0] < 0 || curr[0] >= row || matrix[curr[0]][curr[1]] == 1) continue;
            else if(curr[0] == row-1) return true;

            matrix[curr[0]][curr[1]] = 1;
            for(int[] d: DIR){
                int nr = d[0] + curr[0], nc =  d[1] + curr[1];
                queue.offer(new int[]{nr, nc});
            }
        }
        return false;
    }
}
