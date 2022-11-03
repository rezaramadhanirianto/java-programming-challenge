package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            TreeNode trav = stack.pop();
            list.add(trav.val);

            node = trav.right;
        }
        return list;
    }

    ArrayList<Integer> list = new ArrayList();
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
