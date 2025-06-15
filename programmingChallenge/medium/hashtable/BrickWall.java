package programmingChallenge.medium.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/brick-wall/description/
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < wall.size(); i++){
            int index = 0;
            for(int j = 0; j < wall.get(i).size()-1; j++){
                index += wall.get(i).get(j);
                map.put(index, map.getOrDefault(index, wall.size()) - 1);
            }
        }

        int res = wall.size();
        for(int count: map.values()){
            res = Math.min(count, res);
        }
        return res;
    }
}
