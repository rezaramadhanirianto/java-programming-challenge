package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null && right == null) return true;

        Queue<TreeNode> queueLeft = new LinkedList();
        Queue<TreeNode> queueRight = new LinkedList();
        queueLeft.offer(left);
        queueRight.offer(right);

        while(!queueLeft.isEmpty() && !queueRight.isEmpty()){
            TreeNode nodeLeft = queueLeft.poll();
            TreeNode nodeRight = queueRight.poll();

            if(nodeLeft == null && nodeRight == null) continue;
            else if(nodeLeft == null || nodeRight == null && nodeLeft != nodeRight) return false;
            else if(nodeLeft != null && nodeRight != null && nodeLeft.val != nodeRight.val) return false;

            if(nodeLeft != null){
                queueLeft.offer(nodeLeft.left);
                queueLeft.offer(nodeLeft.right);
            }

            if(nodeRight != null){
                queueRight.offer(nodeRight.right);
                queueRight.offer(nodeRight.left);
            }
        }

        return queueLeft.isEmpty() && queueRight.isEmpty();
    }

    public boolean isSymmetric2(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
