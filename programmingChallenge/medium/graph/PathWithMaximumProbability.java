package programmingChallenge.medium.graph;

import java.util.*;

// https://leetcode.com/problems/path-with-maximum-probability/
public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = buildGraph(edges, succProb);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingDouble(a -> -a.value));
        Set<Integer> visited = new HashSet();
        pq.add(new Node(start, 1));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!visited.add(node.name)) continue;
            if (node.name == end) return node.value;
            if (!graph.containsKey(node.name)) continue;
            for (int key : graph.get(node.name).keySet()) {
                double value = graph.get(node.name).get(key);
                Node next = new Node(key, value * node.value);
                pq.add(next);
            }
        }
        return 0.0;
    }

    private Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> g = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            g.putIfAbsent(edges[i][0], new HashMap<>());
            g.putIfAbsent(edges[i][1], new HashMap<>());
            g.get(edges[i][0]).put(edges[i][1], succProb[i]);
            g.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        return g;
    }

    class Node {
        public double value = -1;
        public int name = -1;

        Node(int name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}
