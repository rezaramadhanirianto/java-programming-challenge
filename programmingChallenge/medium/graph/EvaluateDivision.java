package programmingChallenge.medium.graph;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/
// Binary relationship is represented as a graph usually.
// Does the direction of an edge matters? -- Yes. Take a / b = 2 for example, it indicates a --2--> b as well as b --1/2--> a.
// Thus, it is a directed weighted graph.

// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
// Ex: [["a","b"],["b","c"],["c","d"], ["b","d"]] [2.0,3.0,1.0,1.0]
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            result[i] = (double) getPathWeight(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet());
        }
        return result;
    }

    // find directed graph from start to end
    Double getPathWeight(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited){
        if(!graph.containsKey(start)) return -1.0;
        else if(graph.get(start).containsKey(end)) return graph.get(start).get(end);

        visited.add(start);
        for(Map.Entry<String, Double> node: graph.get(start).entrySet()){
            if(!visited.contains(node.getKey())){
                Double value = getPathWeight(node.getKey(), end, graph, visited);
                if(value != -1.0) return node.getValue() * value;
            }
        }
        return -1.0;
    }

    // build directed weighted graph
    Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap();
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            graph.putIfAbsent(equation.get(0), new HashMap());
            graph.putIfAbsent(equation.get(1), new HashMap());

            graph.get(equation.get(0)).put(equation.get(1), values[i]);
            graph.get(equation.get(1)).put(equation.get(0), 1/values[i]);
        }
        return graph;
    }

    static class AnotherSolution{
        public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, List<Node>> graph = buildGraph2(equations, values);
            double[] result = new double[queries.size()];
            for(int i = 0; i < queries.size(); i++){
                result[i] = dfs2(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
            }
            return result;
        }

        double dfs2(String pair1, String pair2, Set<String> visited, Map<String, List<Node>> graph){
            if(!graph.containsKey(pair1) || !graph.containsKey(pair2)) return -1.0;
            else if(pair1.equals(pair2)) return 1.0;

            visited.add(pair1);
            for(Node node: graph.get(pair1)){
                if(!visited.contains(node.key)){
                    double ans = dfs2(node.key, pair2, visited, graph);
                    if(ans != -1.0) return node.value * ans;
                }
            }
            return -1.0;

        }

        Map<String, List<Node>> buildGraph2(List<List<String>> equations, double[] values){
            Map<String, List<Node>> graph = new HashMap();
            for(int i = 0; i < values.length; i++){
                graph.putIfAbsent(equations.get(i).get(0), new ArrayList());
                graph.putIfAbsent(equations.get(i).get(1), new ArrayList());

                graph.get(equations.get(i).get(0)).add(new Node(equations.get(i).get(1), values[i]));
                graph.get(equations.get(i).get(1)).add(new Node(equations.get(i).get(0), 1/values[i]));
            }
            return graph;
        }

        class Node{
            String key;
            double value;
            Node(String key, double value){
                this.key = key;
                this.value = value;
            }
        }
    }
}
