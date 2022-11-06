package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;

        Stack<TreeNode> queue = new Stack();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();

            TreeNode left = node.left;
            TreeNode right = node.right;

            node.right = left;
            node.left = right;

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return root;
    }
}
