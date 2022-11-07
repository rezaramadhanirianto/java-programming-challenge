package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTree {

    // my solution
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    TreeNode merge(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return null;
        TreeNode newNode1 = (node1 != null) ? node1 : new TreeNode(0);
        TreeNode newNode2 = (node2 != null) ? node2 : new TreeNode(0);
        TreeNode newNode = new TreeNode(newNode1.val + newNode2.val);

        newNode.left = merge(newNode1.left, newNode2.left);
        newNode.right = merge(newNode1.right, newNode2.right);

        return newNode;
    }

    // cleaner solution
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // iterative
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack< TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
