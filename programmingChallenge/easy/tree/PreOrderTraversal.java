package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> output = new ArrayList();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            output.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return output;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null){
            result.add(root.val);
            result.addAll(preorderTraversal2(root.left));
            result.addAll(preorderTraversal2(root.right));
        }
        return result;
    }
}
