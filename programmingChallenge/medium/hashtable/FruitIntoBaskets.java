package programmingChallenge.medium.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> curr = new HashMap();
        int j = -1, res = 0, n = fruits.length;
        for(int i = 0; i < n; i++){
            int fruit = fruits[i];
            if(curr.size() == 2 && !curr.containsKey(fruit)){
                int min = Collections.min(curr.values());
                j = min;
                curr.remove(fruits[min]);
            }
            res = Math.max(res, i - j);
            curr.put(fruit, i);
        }
        return res;
    }
}
