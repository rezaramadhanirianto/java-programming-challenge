package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> value = new Stack();
        value.push(1);
        stack.push(root);
        int max = Integer.MIN_VALUE;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            Integer temp = value.pop();
            max = Math.max(max, temp);

            if(node.left != null){
                stack.push(node.left);
                value.push(temp+1);
            }

            if(node.right != null){
                stack.push(node.right);
                value.push(temp+1);
            }
        }

        return max;
    }
}
