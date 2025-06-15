package programmingChallenge.medium.graph;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightWithKStops {
    // bellman ford
    // this is similar with bellman ford standard algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            // main different is here
            // because bellman ford only can return value after (n - 1) loop
            // we use this method to make it work in k loop
            // it's work like check step by step
            // ex: (Graph)
            // 0 - 1 -> 1
            // 0 - 3 -> 5
            // 1 - 2 -> 2
            // in standard algorithm we create dp like
            // [0, 1, 3, 5]
            // but if we do that it's like 2 step => 0 -> 1 -> 2
            // that's why we check to the previous step
            // reality
            // [0, 1, INF, 5] 1 Loop
            // [0, 1, 3, 5] 2 Loop
            int[] temp = Arrays.copyOf(dist, n);
            for(int[] flight: flights){
                int curr = flight[0];
                int next = flight[1];
                int cost = flight[2];
                if(dist[curr] == Integer.MAX_VALUE) continue;
                //                   this code to check the prev step
                temp[next] = Math.min(temp[next], dist[curr] + cost);
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // dijkstra
    // it's TLE (Time Limit Exception)
    // because we sacrifice the visited to manage k step that's why TLE
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap();
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));

        for(int[] flight: flights){
            List<int[]> next = graph.getOrDefault(flight[0], new ArrayList());
            next.add(new int[]{flight[1], flight[2]});
            graph.put(flight[0], next);
        }

        pq.add(new int[]{src, 0, k+1});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(node[0] == dst) return node[1];
            if(graph.get(node[0]) == null) continue;
            if(node[2] < 1) continue;
            for(int[] next: graph.get(node[0])){
                int[] curr = new int[]{next[0], node[1] + next[1], node[2] - 1};
                pq.add(curr);
            }
        }
        return -1;
    }

    // O (N*M)
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList();

        for(int[] flight: flights){
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        return helper(graph, new Integer[k+2][n], src, dst, k+1);
    }

    int helper(List<int[]>[] graph, Integer[][] dp, int src, int dest, int k){
        if(k < 0) return -1;
        else if(src == dest) return 0;
        else if(dp[k][src] != null) return dp[k][src];

        int min = Integer.MAX_VALUE;
        for(int[] next: graph[src]){
            int res = helper(graph, dp, next[0], dest, k-1);

            if(res != -1) min = Math.min(min, res + next[1]);
        }

        return dp[k][src] = (min == Integer.MAX_VALUE) ? -1 : min;
    }

}
