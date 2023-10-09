package programmingChallenge.unclassified;

/**
 * Given Binary tree, in it we call a perfect tree as when it has 0 or 2 childern for a node.
 * Question: We need to return the maximum possible perfect subtree size ( i.e count of all nodes in a perfect subtree ) that can formed in a given binary tree by removing some nodes.
 *
 * Example:
 *
 * 		  18
 *        /       \
 *      15         30
 *     /  \        /  \
 *   40    50    100   40
 *  /  \   /
 * 8   7  9
 *
 *  	By removing node 9, we get the maximum possible perfect tree with size  is 9
 *
 * 		   18
 *        /       \
 *      15         30
 *     /  \        /  \
 *   40    50    100   40
 *  /  \
 * 8   7
 * */
public class CountMaximumBinaryTree {
    static int res = 0;
    static int solution(TreeNode node){
        helper(node);
        return res;
    }

    static int helper(TreeNode node){
        if(node.left == null && node.right == null) return 1;
        int sum = 1;
        if(node.left != null) sum += helper(node.left);
        if(node.right != null) sum += helper(node.right);
        if(node.left == null || node.right == null) return 0;
        res = Math.max(res, sum);
        return sum;
    }

    /**
     *            18
     *        /       \
     *      15         30
     *     /  \          \
     *   40    50         40
     *  /  \   /         /  \
     * 8   7  9         10   15
     *                 / \   / \
     *                7   9  4  6
     *               / \
     *              1   2
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(40);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(7);
        root.left.right = new TreeNode(50);
        root.left.right.left = new TreeNode(9);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(7);
        root.right.right.left.left.left = new TreeNode(1);
        root.right.right.left.left.right = new TreeNode(2);
        root.right.right.left.right = new TreeNode(9);
        root.right.right.right = new TreeNode(15);
        root.right.right.right.left = new TreeNode(4);
        root.right.right.right.right = new TreeNode(6);

        int res = solution(root);
        System.out.println(res);
    }

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val){
            this.val = val;
        }

    }
}
