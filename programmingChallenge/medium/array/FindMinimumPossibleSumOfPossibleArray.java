package programmingChallenge.medium.array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/
public class FindMinimumPossibleSumOfPossibleArray {
    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet();
        int[] arr = new int[n];
        int i = 1, j = 0;
        while(j < n){
            while(set.contains(target - i)){
                i++;
            }
            set.add(i);
            arr[j++] = i++;
        }
        long res = 0;
        for(int ar: arr) res += ar;
        return res;
    }
}
