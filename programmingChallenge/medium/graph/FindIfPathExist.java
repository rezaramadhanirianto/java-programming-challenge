package programmingChallenge.medium.graph;

import java.util.*;

// https://leetcode.com/problems/find-if-path-exists-in-graph
public class FindIfPathExist {

    // DFS
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Map<List<Integer>>
        // HashSet<Integer>[] = new HashSet[n];
        // List<List<Integer>>
        Map<Integer, List<Integer>> lists = new HashMap();
        for(int i = 0; i < n; i++){ lists.put(i, new ArrayList()); }
        for(int[] edge: edges){
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        if(source == destination) return true;
        dfs(lists, new boolean[n], source, destination);
        return found;
    }

    void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int target){
        if(visited[source] || found) return;

        visited[source] = true;
        for(Integer g: graph.get(source)){
            if(g.equals(target)){
                found = true;
                break;
            }
            if(!visited[g]) dfs(graph, visited, g, target);
        }
    }
    // END DFS

    // BFS
    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> lists = new HashMap();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){ lists.put(i, new ArrayList()); }
        for(int[] edge: edges){
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        if(source == destination) return true;

        Queue<Integer> queue = new LinkedList();
        int current = source;
        queue.offer(current);
        visited[current] = true;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(current == destination) return true;

            visited[current] = true;
            for(Integer num: lists.get(current)){
                if(!visited[num]){
                    queue.offer(num);
                }
            }
        }

        return false;
    }

    // union find
    public boolean validPath3(int n, int[][] edges, int source, int destination) {
        UnionFind union = new UnionFind(n);
        for(int[] edge: edges){
            union.unify(edge[0], edge[1]);
        }
        return union.find(source) == union.find(destination);
    }

    static class UnionFind{
        private int data[];

        public UnionFind(int n){
            data = new int[n];
            for(int i = 0; i < n; i++) data[i] = i;
        }

        public void unify(int p, int q){
            int parentP = find(p);
            int parentQ = find(q);
            data[parentP] = parentQ;
        }

        public int find(int p){
            int root = p;
            while(root != data[root]) root = data[root];
            return root;
        }
    }
}