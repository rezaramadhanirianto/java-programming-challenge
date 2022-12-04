package programmingChallenge.utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int val;
    public List<Graph> neighbors;
    public Graph() {
        val = 0;
        neighbors = new ArrayList<Graph>();
    }
    public Graph(int _val) {
        val = _val;
        neighbors = new ArrayList<Graph>();
    }
    public Graph(int _val, ArrayList<Graph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}