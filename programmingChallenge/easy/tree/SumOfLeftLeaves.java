package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root, false);
    }

    // my solution
    int sumLeft(TreeNode node, boolean isLeft){
        int sum = 0;
        if(node.left != null) sum += sumLeft(node.left, true);
        if(node.right != null) sum += sumLeft(node.right, false);
        if(isLeft && node.left == null && node.right == null) sum += node.val;
        return sum;
    }

    // clean solution
    int sumLeft2(TreeNode node, boolean isLeft){
        if(node == null) return 0;
        if(isLeft && node.left == null && node.right == null) return node.val;
        return sumLeft(node.left, true) + sumLeft(node.right, false);
    }

    // iterative
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}
