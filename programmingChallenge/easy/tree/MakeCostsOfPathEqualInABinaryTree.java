package programmingChallenge.easy.tree;

// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/
public class MakeCostsOfPathEqualInABinaryTree {
    int res = 0;
    public int minIncrements(int n, int[] cost) {
        dfs(0, cost);
        return res;
    }
    private int dfs(int i, int[] cost) {
        if(i >= cost.length) return 0;
        int left = dfs(i*2+1, cost), right = dfs(i*2+2,cost);
        res += Math.abs(left - right);
        return cost[i] + Math.max(left, right);
    }
}
