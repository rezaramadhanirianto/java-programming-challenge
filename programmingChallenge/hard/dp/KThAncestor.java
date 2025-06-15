package programmingChallenge.hard.dp;

// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/description/
public class KThAncestor {
    private Integer[][] jumps;

    public KThAncestor(int n, int[] parent) {
        int numJumps = (int) Math.ceil(Math.log(n) / Math.log(2));
        jumps = new Integer[n][numJumps];
        for(int node = 1; node < n; node++){
            jumps[node][0] = parent[node];
        }
        for(int jump = 1; jump < numJumps; jump++){
            for(int node = 1; node < n; node++){
                Integer mid = jumps[node][jump-1];
                jumps[node][jump] = mid != null ? jumps[mid][jump-1] : null;
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int jump = jumps[0].length - 1;
        Integer curr = node;
        while(k > 0 && curr != null){
            if(k >= 1 << jump){
                curr = jumps[curr][jump];
                k -= 1 << jump;
            } else {
                jump--;
            }
        }
        return (curr == null) ? -1 : curr;
    }
}
