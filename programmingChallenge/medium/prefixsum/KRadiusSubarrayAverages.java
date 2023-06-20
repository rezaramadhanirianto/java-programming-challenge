package programmingChallenge.medium.prefixsum;

import java.util.Arrays;

// https://leetcode.com/problems/k-radius-subarray-averages/description/
public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n];
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        if(k*2 + 1 > n) return averages;

        sum[0] = nums[0];
        for(int i = 1; i < n; i++) sum[i] += sum[i-1] + nums[i];

        for(int i = k; i + k < n; i++){
            long curr = 0;
            if(i-k-1 >= 0) curr -= sum[i-k-1];
            curr += sum[i+k];
            averages[i] = (int) (curr/(k*2+1));
        }

        return averages;
    }
}
