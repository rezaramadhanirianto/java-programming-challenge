package programmingChallenge.medium.greedy;

// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int res = 0, negative = 0, firstNegative = -1, zero = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                negative++;
                if(firstNegative == -1) firstNegative = i;
            }

            if(nums[i] == 0){
                negative = 0;
                firstNegative = -1;
                zero = i;
            }else{
                if(negative % 2 == 0) res = Math.max(res, i - zero);
                else res = Math.max(res, i - firstNegative);
            }
        }
        return res;
    }

    public int getMaxLen2(int[] nums) {
        int res = 0, negative = 0, positive = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = positive;
                positive = negative == 0 ? 0 : negative +1;
                negative = temp+1;
            }else if(nums[i] > 0){
                positive++;
                negative = negative == 0 ? 0 : negative+1;
            }else{
                negative = positive = 0;
            }

            res = Math.max(res, positive);
        }
        return res;
    }

}
