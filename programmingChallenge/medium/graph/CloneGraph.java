package programmingChallenge.medium.graph;

import programmingChallenge.utils.Graph;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/clone-graph/
// DFS using map, if we found map contains node, that means we already found it before, just return it
// Ex:
// 0 - 1
//  \  |
//    2
// DFS
// 0 -> [0, 0]

// First Neighbor "0"
// 0 += 1 -> [1, 2]
// 1 += 2 -> [2, 0]
// 2 += 0 -> break first neighbor of "0"

// that means 0 - 1
//            ^   |
//            |   2
// 0 doesn't have neighbor of item 2

// Second Neighbor "0"
// 0 += 2 -> break
// result
// 0 - 1
//  \  |
//    2
public class CloneGraph {
    Map<Graph, Graph> map = new HashMap();
    public Graph cloneGraph(Graph node) {
        return dfs(node);
    }

    Graph dfs(Graph node){
        if(node == null) return node;
        else if(map.containsKey(node)) return map.get(node);
        Graph curr = new Graph(node.val);
        map.put(node, curr);
        for(Graph neighbor: node.neighbors){
            curr.neighbors.add(dfs(neighbor));
        }
        return curr;
    }
}
