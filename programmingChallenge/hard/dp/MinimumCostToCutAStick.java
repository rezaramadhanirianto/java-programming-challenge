package programmingChallenge.hard.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        return helper(0, n, cuts, new HashMap<>());
    }

    int helper(int start, int end, int[] cuts, Map<String, Integer> map){
        if(end - start <= 1) return 0;
        String key = start + "-" + end;
        if(map.containsKey(key)) return map.get(key);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < cuts.length; i++){
            if(cuts[i] > start && cuts[i] < end){
                int left = helper(start, cuts[i], cuts, map);
                int right = helper(cuts[i], end, cuts, map);
                min = Math.min(min, left + right + (end - start));
            }
        }

        map.put(key, (min == Integer.MAX_VALUE) ? 0 : min);
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
