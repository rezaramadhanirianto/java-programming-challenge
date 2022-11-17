package programmingChallenge.medium.matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for(int i = 0; i <= length/2; i++){
            for(int j = i; j < length -i;j++){
                int p1 = matrix[i][j];
                int p2 = matrix[j][length-i];
                int p3 = matrix[length-i][length-j];
                int p4 = matrix[length-j][i];

                matrix[i][j] = p4;
                matrix[j][length-i] = p1;
                matrix[length-i][length-j] = p2;
                matrix[length-j][i] = p3;
            }
        }
    }
}
