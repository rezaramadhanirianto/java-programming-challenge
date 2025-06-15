package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0], min = nums[0], max = nums[0];
        for(int i = 1; i < n; i++){
            int tempMax = max;
            max = Math.max(max*nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(min*nums[i], Math.min(tempMax*nums[i], nums[i]));
            res = Math.max(res, Math.max(max, min));
        }
        return res;
    }
}
