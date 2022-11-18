package programmingChallenge.medium.matrix;

public class Search2DMatrix {
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            if(matrix[i][m-1] >= target){
                return find(matrix, i, target);
            }
        }
        return false;
    }

    boolean find(int[][] matrix, int row, int target){
        int low = 0;
        int high = matrix[row].length-1;

        while(low <= high){
            int temp = (low + high)/2;
            if(matrix[row][temp] == target){
                return true;
            }else if(matrix[row][temp] > target){
                high = temp-1;
            }else{
                low = temp+1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length * matrix.length -1;
        int col = matrix[0].length;
        int start = 0;
        int high = n;

        while(start <= high){
            int mid = start + (high - start)/2;
            if(matrix[mid/col][mid%col] > target) high = mid -1;
            else if(matrix[mid/col][mid%col] < target) start = mid +1;
            else return true;
        }

        return false;
    }
}
