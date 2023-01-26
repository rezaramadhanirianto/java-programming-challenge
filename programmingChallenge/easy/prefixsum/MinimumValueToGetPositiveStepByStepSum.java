package programmingChallenge.easy.prefixsum;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
public class MinimumValueToGetPositiveStepByStepSum {
    // O(N) Space
    public int minStartValue(int[] nums) {
        int[] diff = new int[nums.length];
        int n = nums.length;
        diff[0] = nums[0];
        for(int i = 1; i < n; i++) diff[i] = nums[i] + diff[i-1];

        int min = 1;
        for(int d: diff){
            if(min + d <= 0){
                int dif = min + d;
                min += Math.abs(dif)+1;
            }
        }
        return min;
    }

    // O(1) Space
    public int minStartValue2(int[] nums) {
        int n = nums.length;
        int min = 1, sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(min + sum <= 0){
                int dif = min + sum;
                min += Math.abs(dif)+1;
            }
        }
        return min;
    }
}
