package programmingChallenge.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    Map<String, Boolean> visited = new HashMap();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        helper(candidates, target, 0, 0, new ArrayList(), res);
        return res;
    }

    void helper(int[] candidates, int target, int start, int curr, List<Integer> wrapper, List<List<Integer>> res){
        if(curr > target) return;
        if(curr == target){
            res.add(new ArrayList(wrapper));
        }

        for(int i = start; i < candidates.length; i++){
            wrapper.add(candidates[i]);
            helper(candidates, target, i, curr+candidates[i], wrapper, res);
            wrapper.remove(wrapper.size()-1);
        }
    }
}
