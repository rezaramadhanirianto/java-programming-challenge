package programmingChallenge.hard.binarysearch;

// https://leetcode.com/problems/minimum-cost-to-make-array-equal/
// see visualization here: /assets/minimum_cost_to_make_all_array_equal.jpeg
public class MinimumCostToMakeArrayEqual {
    public long minCost(int[] nums, int[] costs) {
        int lo = 1, hi = (int) 1e6;
        long res = Long.MAX_VALUE;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            long cost1 = getCost(nums, costs, mid);
            long cost2 = getCost(nums, costs, mid+1);
            res = Math.min(cost1, cost2);

            // if cost1 > cost2
            // that means smallest element in right like convex U
            // otherwise smallest element in left
            if(cost1 > cost2){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return res;
    }

    long getCost(int[] nums, int[] costs, int i){
        long res = 0;
        for(int j = 0; j < nums.length; j++){
            long diff = Math.abs(nums[j] - i);
            res += diff * costs[j];
        }
        return res;
    }
}
