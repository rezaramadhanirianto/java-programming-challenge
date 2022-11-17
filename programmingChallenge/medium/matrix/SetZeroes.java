package programmingChallenge.medium.matrix;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isRowZero = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0) isRowZero = true;
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = matrix.length-1; i >= 0; i--){
            for(int j = matrix[0].length-1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(isRowZero) matrix[i][0] = 0;
        }
    }
}
