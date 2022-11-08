package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNotesHelper(root, Integer.MIN_VALUE);
    }

    int goodNotesHelper(TreeNode node, int max){
        int sum = 0;
        if(max <= node.val){
            sum++;
            max = node.val;
        }

        if(node.left != null) sum += goodNotesHelper(node.left, max);
        if(node.right != null) sum += goodNotesHelper(node.right, max);

        return sum;
    }
}
