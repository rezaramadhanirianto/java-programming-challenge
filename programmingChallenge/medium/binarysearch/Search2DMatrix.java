package programmingChallenge.medium.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/
// input:
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
// 3
public class Search2DMatrix {
     public boolean searchMatrix(int[][] matrix, int target) {
         for(int[] m: matrix){
             int f = m[0];
             int s = m[m.length-1];

             if(target <= s && target >= f) return find(m, target);
         }
         return false;
     }

     boolean find(int[] nums, int target){
         int low = 0;
         int high = nums.length - 1;
         while(low <= high){
             int mid = low + (high - low)/2;
             if(nums[mid] < target) low = mid + 1;
             else if(nums[mid] == target) return true;
             else high = mid -1;
         }
         return false;
     }


    // this approach basically not see matrix as a real matrix
    // but as a sorted list
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix[0].length * matrix.length -1;
        int col = matrix[0].length;
        int start = 0;
        int high = n;

        while(start <= high){
            int mid = start + (high - start)/2;
            // [[3,5,6,12,15,16],[20,22,23,26,28,30]]
            // column = mid/column
            // row    = mid%column
            // Mid: 5  Col: 0 Row: 5
            // Mid: 8  Col: 1 Row: 2
            // Mid: 10 Col: 1 Row: 4
            // Mid: 11 Col: 1 Row: 5
            if(matrix[mid/col][mid%col] > target) high = mid -1;
            else if(matrix[mid/col][mid%col] < target) start = mid +1;
            else return true;
        }

        return false;
    }
}
