package programmingChallenge.unclassified;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// will add question next time
public class SmallestCostOfDelivery {
    public static void main(String[] args) {
        int[][] orders = new int[][]{{2,5}, {5,1}};
        int[][] paths = new int[][]{{1,2,3000}, {1,5,7000},{2,1,3000},{2,3,2000},{3,5,5000},{4,1,5000},{5,4,5000},{5,3,5000},{3,2,1000}};
        int n = 0;
        List<List<int[]>> graph  = new ArrayList<>();

        for(int path[]: paths){
            n = Math.max(path[0], n);
            n = Math.max(path[1], n);
        }
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        for(int i = 0; i < paths.length; i++){
            graph.get(paths[i][0]).add(new int[]{paths[i][1], paths[i][2]});
        }

        pq.add(new Node(1, 0, "1"));
        int i = 0;
        while(i < orders.length){
            int[] order = orders[i];
            while(!pq.isEmpty()){
                Node curr = pq.poll();
                if(order[0] != -1){
                    if(order[0] == curr.node) {
                        pq.clear();
                        order[0] = -1;
                    }
                } else{
                    if(order[1] == curr.node && i == orders.length - 1) {
                        System.out.println(curr.path);
                        return;
                    }
                    if(order[1] == curr.node) {
                        i++;
                        pq.clear();
                        pq.add(curr);
                        break;
                    }
                }
                for(int[] next: graph.get(curr.node)){
                    String key = curr.path + " " + next[0];
                    Node forw = new Node(next[0], next[1] + curr.cost, key);
                    pq.add(forw);
                }
            }
        }
    }
}

class Node {
    int node;
    int cost;
    String path;

    Node(int node, int cost, String path){
        this.node = node;
        this.cost = cost;
        this.path = path;
    }
}
