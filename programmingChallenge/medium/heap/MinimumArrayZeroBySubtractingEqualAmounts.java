package programmingChallenge.medium.heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
public class MinimumArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int num: nums){
            if(num == 0 || num - sum == 0) continue;
            else{
                num -= sum;
                sum += num;
                res++;
            }
        }
        return res;
    }

    public int minimumOperations2(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums){
            if(num > 0) set.add(num);
        }
        return set.size();
    }
}
