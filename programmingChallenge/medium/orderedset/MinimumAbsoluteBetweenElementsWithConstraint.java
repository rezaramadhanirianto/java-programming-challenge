package programmingChallenge.medium.orderedset;

import java.util.List;
import java.util.TreeSet;

// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/
public class MinimumAbsoluteBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int res = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet();
        for(int i = x; i < nums.size(); i++){
            set.add(nums.get(i - x));

            Integer ceil = set.ceiling(nums.get(i));
            if(ceil != null) res = Math.min(res, Math.abs(ceil - nums.get(i)));

            Integer floor = set.floor(nums.get(i));
            if(floor != null) res = Math.min(res, Math.abs(floor - nums.get(i)));
        }
        return res;
    }
}
