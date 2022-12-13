package programmingChallenge.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
// only bfs with every node check their neighbors
public class FlowerPlantingWithNoAdjacent {
    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            int[] res = new int[n];
            Map<Integer, List<Integer>> graph = buildGraph(n, paths);

            for(int i = 1; i <= n; i++){
                Integer node = i;
                int[] neighbors = new int[]{1,2,3,4};
                if(graph.get(node) != null){
                    for(Integer next: graph.get(node)){
                        if(res[next-1] == 0) continue;
                        neighbors[(res[next-1] - 1)] = 0;
                    }
                }

                for(int nei: neighbors){
                    if(nei != 0){
                        res[node-1] = nei;
                        break;
                    }
                }
            }
            return res;
        }

        Map<Integer, List<Integer>> buildGraph(int n, int[][] paths){
            Map<Integer, List<Integer>> graph = new HashMap();
            for(int[] path: paths){
                graph.putIfAbsent(path[0], new ArrayList());
                graph.putIfAbsent(path[1], new ArrayList());

                graph.get(path[0]).add(path[1]);
                graph.get(path[1]).add(path[0]);
            }
            return graph;
        }
    }
}
