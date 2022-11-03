package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        Set<TreeNode> visited = new HashSet();
        TreeNode trav = root;
        while(trav != null && !visited.contains(trav)){
            if(trav.left != null && !visited.contains(trav.left)){
                trav = trav.left;
            }else if(trav.right != null && !visited.contains(trav.right)){
                trav = trav.right;
            }else{
                list.add(trav.val);
                visited.add(trav);
                trav = root;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.addFirst(node.val);

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return list;
    }

    private List<Integer> arr = new ArrayList();
    public List<Integer> postorderTraversal3(TreeNode root) {
        postOrder(root);
        return arr;
    }
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            arr.add(root.val);
        }
    }
}
