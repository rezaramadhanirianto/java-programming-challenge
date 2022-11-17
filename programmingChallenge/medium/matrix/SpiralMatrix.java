package programmingChallenge.medium.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            // right
            for(int i = colBegin; i <= colEnd; i++) list.add(matrix[rowBegin][i]);
            rowBegin++;

            // bottom
            for(int i = rowBegin; i <= rowEnd; i++) list.add(matrix[i][colEnd]);
            colEnd--;

            // left
            if(rowBegin <= rowEnd){
                for(int i = colEnd; i >= colBegin; i--) list.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // up
            if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--) list.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return list;
    }
}
