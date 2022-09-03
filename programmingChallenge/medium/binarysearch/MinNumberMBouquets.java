package programmingChallenge.medium.binarysearch;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
// [binary search]
public class MinNumberMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 0;
        // get flower max day that need bloom
        for(int day: bloomDay) if(right < day) right = day;

        int output = -1;
        // binary search based on day flower that need bloom
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(bloomDay, m, k, mid)){
                right = mid - 1;
                output = mid;
            }else{
                left = mid + 1;
            }
        }
        return output;
    }

    // check if it's possible we can create bouquets or not
    boolean isPossible(int[] bloomDay, int m, int k, int days){
        int count = 0, adjacent = 0;
        for(int b: bloomDay){
            if(b <= days){
                adjacent++;
                if(adjacent == k){
                    count++;
                    if(count == m) return true;
                    adjacent = 0;
                }
            }else{
                adjacent = 0;
            }
        }
        return false;
    }
}
