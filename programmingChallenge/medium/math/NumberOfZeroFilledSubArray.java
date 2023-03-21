package programmingChallenge.medium.math;

// https://leetcode.com/problems/number-of-zero-filled-subarrays/
public class NumberOfZeroFilledSubArray {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int seq = 0;
        for(int num: nums){
            if(num == 0) seq++;
            else seq = 0;
            res += seq;
        }
        return res;
    }
}
