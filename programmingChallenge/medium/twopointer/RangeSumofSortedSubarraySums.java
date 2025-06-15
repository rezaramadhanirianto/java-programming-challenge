package programmingChallenge.medium.twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumofSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        int res = 0;
        for(int i = left; i <= right; i++){
            res += list.get(i);
        }
        return res;
    }
}
