package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    // using iterative and inorder traversal
    // using inorder is like show value from lower to higher
    // that's why if we check current <= previous it would be invalid bst
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack();
        TreeNode pre = null;

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if(root == null) return false;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValid(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
