package programmingChallenge.easy.math;

// https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
public class CheckIfStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        for(int i = 2; i < coordinates.length; i++){
            // y2 - y1/x2-x1 = y3 - y2/x3-x2
            // (y2 - y1) * (x3 - x2) == (x2 - x1) * (y3 - y2)
            int[] curr = coordinates[i];
            if((y1 - y0) * (curr[0] - x1) != (x1 - x0) * (curr[1] - y1)) return false;

        }
        return true;
    }
}
