package programmingChallenge.hard.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * O (N * N * 2 ^ N)
 * time complexity will be equal to work for each element we push and pop from que.
 * every node can have 2^n state because of mask.
 * total number of nodes are n,
 * therefore in worst case we will push n * 2^n states in queue and pop them.
 * now for every state we will try to check it neighbors and see if we can push them.
 * A node can have O(n) neighbors.
 * */
// https://leetcode.com/problems/shortest-path-visiting-all-nodes
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        int level = 0;
        Set<String> visited = new HashSet();
        Queue<Node> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1<<i);
            queue.offer(node);
            visited.add(node.toString());
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node node = queue.poll();
                if(node.mask == fullMask) return level;
                for(int next: graph[node.num]){
                    Node nodeNext = new Node(next, (node.mask | (1 << next)));
                    if(visited.add(nodeNext.toString())){
                        queue.add(nodeNext);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    class Node{
        int num;
        int mask;

        Node(int num, int mask){
            this.num = num;
            this.mask = mask;
        }


        public String toString() {
            return num + " " + mask;
        }
    }
}
