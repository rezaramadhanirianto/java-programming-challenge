package programmingChallenge.easy.binarysearch;

import java.util.Arrays;

public class ArrangeCoins {
    // binary search approach
    public int arrangeCoins(int n) {
        long low = 0, high = n;
        while(low <= high){
            long mid = low + (high - low)/2;
            long sum = mid * (mid +1)/2;

            if(sum == n){
                return (int) mid;
            } else if(sum > n){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return (int) low - 1;
    }

     public int arrangeCoins2(int n) {
         int row = 1;
         while(n > 0){
             n = n - row;
             row++;
         }
         return row - 1;
     }

    public static void main(String[] args){
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        int data = arrangeCoins.arrangeCoins(5);
        System.out.println(data);
    }
}
