package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// note: space complexity should be O(1) or Constant
public class PopulatingNextRightPointerInEachNode {
    public TreeNode connect(TreeNode root) {
        TreeNode node = root;
        while(node != null){
            TreeNode start = node;
            while(start != null){
                if(start.left != null) start.left.next = start.right;
                if(start.right != null && start.next != null) start.right.next = start.next.left;

                start = start.next;
            }
            node = node.left;
        }
        return root;
    }

    public TreeNode connect2(TreeNode root) {
        if(root == null) return root;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
        return root;
    }
}
